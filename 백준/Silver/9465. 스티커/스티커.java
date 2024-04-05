import java.io.*;
import java.util.*;

public class Main {
    static int T, N ,answer;
    static int input[][], dp[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            answer = 0;

            input = new int[2][N];
            dp = new int[N][3];
            for(int i=0;i<2;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    input[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][0] = input[0][0];
            dp[0][1] = input[1][0];
            for(int j=1;j<N;j++){
                dp[j][2] = Math.max(dp[j-1][0], dp[j-1][1]);
                
                dp[j][0] = Math.max(dp[j-1][1], dp[j-1][2])+input[0][j];
                dp[j][1] = Math.max(dp[j-1][0], dp[j-1][2])+input[1][j];
            }
            
            answer = Math.max(dp[N-1][0],dp[N-1][1]);
            answer = Math.max(dp[N-1][2],answer);

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
