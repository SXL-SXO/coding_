import java.io.*;

public class B_123더하기_9095 {
    static int T, N;
    static StringBuilder sb = new StringBuilder();
    static int dp[] = new int[12];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        for(int i=5;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append("\n");
        }
        System.out.println(sb);
    }
}
