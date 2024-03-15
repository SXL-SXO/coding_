import java.io.*;
/**
 * B_2N타일링2_11727
 */
public class B_2N타일링2_11727 {
    static int N;
    static int dp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[1]=1;
        for(int i=2;i<=N;i++){
            if(i%2==0) dp[i] = (dp[i-1]*2+1)%10007;
            else dp[i] = dp[i] = (dp[i-1]*2-1)%10007;
        }
        System.out.println(dp[N]);
        /*
         * 
         * n=1 1
         * n=2 3
         * n=3 5
         * n=4 11
         * n=5 21
         * n=6 42+1 43
         * n=7 86-1 85
         * n=8 170+1
         */
        
    }
}