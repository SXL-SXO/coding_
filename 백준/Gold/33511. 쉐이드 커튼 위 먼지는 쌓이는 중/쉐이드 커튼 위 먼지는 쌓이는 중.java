
import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static int input[][];
    static int answer[];
    static boolean visit[], num[];
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        for(int i=0;i<N;i++)
            set.add(br.readLine());

        distinct();
        make();
        write();

        System.out.println(sb);
    }
    static void write(){
        for(int j=0;j<M;j++) sb.append(answer[j]).append(" ");
    }
    static void make(){
        visit = new boolean[M];
        int count = 0;
        for(int i=0;i<N-1;i++){
            if(count == M) return;
            for(int j=0;j<M;j++){
                if(input[i][j]==input[i+1][j]) {
                    answer[j] = input[i][j];
                    if(!visit[j]) count++;
                    visit[j] = true;
                }
            }
        }
        for(int i=0;i<N-2;i++){
            if(count == M) return;
            for(int j=0;j<M;j++){
                if(input[i][j]==input[i+2][j]) {
                    answer[j] = input[i][j];
                    if(!visit[j]) count++;
                    visit[j] = true;
                }
            }
        }
//	    System.out.print(Arrays.toString(answer));
        //하나만 비는 경우
        for(int j=0;j<M;j++){
            boolean num[] = new boolean[2001];
            if(!visit[j]){
                for(int i=0;i<N;i++) {
                    if(check(i, j)) num[input[i][j]] = true;
                    else return;
                }
                for(int k=0;k<2001;k++) {
                    if(!num[k]) {
                        answer[j] = k;
                        return;
                    }
                }
            }
        }
    }
    static boolean check(int a, int b){
        for(int j=0;j<M;j++){
            if(j==b) continue;
            if(input[a][j] != answer[j]) {
                answer[b] = input[a][b];
                return false;
            }
        }
        return true;
    }
    static void distinct(){

        N = set.size();
        input = new int[N][M];

        Iterator it = set.iterator();
        StringTokenizer st = new StringTokenizer((String)it.next());
        for(int j=0;j<M;j++){
            answer[j] = input[0][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<N;i++){
            st = new StringTokenizer((String)it.next());
            for(int j=0;j<M;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(input[i]));
        }
    }
}
