import java.io.*;
import java.util.*;

public class B_케빈베이컨의6단계법칙_1389 {
    static int N, M, INF, answer_n=0, answer_v = INF = 500000;
    static int map[][] = new int[101][101];
    static boolean visit[] = new boolean[101];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int A,B;
        for(int i=0;i<=N;i++){
            Arrays.fill(map[i],INF);
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visit[A] = true;
            visit[B] = true;
            map[A][B] = 1;
            map[B][A] = 1;
        }
        for(int i=1;i<101;i++){
            for(int j=1;j<101;j++){
                for(int k=1;k<101;k++){
                    if(visit[i]&&visit[j]&&visit[k]) map[j][i] = map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        for(int i=1;i<101;i++){
            if(!visit[i]) continue;
            int result = check(i);
            if(result>=answer_v) continue;
            answer_n = i;
            answer_v = result;
        }
        System.out.println(answer_n);
    }
    static int check(int now){
        int count =0;
        for(int i=1;i<101;i++)
            if(visit[i]) count+=map[now][i];
        return count;
    }
}