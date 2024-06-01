import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int N, M;
    static int star[];
    static int group[];
    static Map<Integer, Integer> count = new HashMap<>();

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        star = new int[N+1];
        group = new int[N+1];

        for(int i=1;i<=N;i++){
            star[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            check(s1, s2, i);
            sb.append(count.get(group[s1])).append("\n");
        }
        System.out.print(sb);
    }
    static void check(int s1, int s2, int idx){
        // 각자 연결된 행성이 있는지 확인 없으면 서로를 연결
        if(group[s1]==0 && group[s2]==0){
            group[s1] = idx;
            group[s2] = idx;

            count.put(idx, star[s1] + star[s2]);
        }
        // 있으면 연결된 행성의 값들은 업데이트 필요
        else if(group[s1]!=0&&group[s2]!=0){
            // 이미 연결된 행성인지 확인
            if(group[s1]==group[s2]){
                return ;
            }
            count.put(group[s1], count.get(group[s1])+ count.get(group[s2]));
            count.remove(group[s2]);
            for(int i=1;i<=N;i++){
                if(group[i] == group[s2] && i!=s2) group[i] = group[s1];
            }
            group[s2] = group[s1];
        }
        else if(group[s1]!=0){
            group[s2] = group[s1];
            count.put(group[s1], count.get(group[s1]) + star[s2]);
        }
        else if(group[s2]!=0){
            group[s1] = group[s2];
            count.put(group[s2], count.get(group[s2]) + star[s1]);
        }
    }
}