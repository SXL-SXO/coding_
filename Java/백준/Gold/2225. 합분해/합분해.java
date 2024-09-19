import java.io.*;
import java.util.*;

public class Main
{
    static int N, K;
    static int dp[][];
	public static void main(String[] args)throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    dp = new int[N+1][K+1];
	    for(int a=0;a<=N;a++){
	        dp[a][1] = 1;
	    }
	    
	    for(int a=0;a<=N;a++){
             for(int b=1; b<K; b++){
	             for(int c=0;a+c<=N;c++){
	                 dp[a+c][b+1] += dp[a][b];
	                 dp[a+c][b+1] %= 1_000_000_000;
	             }
	         }
	    }
	    
	    System.out.print(dp[N][K]);
	}
}
