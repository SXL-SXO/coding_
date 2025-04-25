import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static long dp[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    dp = new long[N+1][2];
	    
	    dp[1][1] = 1;
	    if(N>=2) dp[2][0] = 1;
	    
	    for(int i=3;i<=N;i++) {
	        dp[i][0] = dp[i-1][0] + dp[i-1][1];
	        dp[i][1] = dp[i-1][0];
	    }
	    System.out.print(dp[N][0]+dp[N][1]);
	}
}