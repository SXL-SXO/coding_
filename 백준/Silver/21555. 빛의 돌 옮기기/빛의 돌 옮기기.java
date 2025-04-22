import java.io.*;
import java.util.*;
public class Main
{
    static int N, M;
    static int A[], B[];
    static long dp[][];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    A = new int[N];
	    B = new int[N];
	    dp = new long[N][2];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) B[i] = Integer.parseInt(st.nextToken());
	    
	    for(int i=1;i<N;i++) Arrays.fill(dp[i], Long.MAX_VALUE);
	    
	    dp[0][0] = A[0];
	    dp[0][1] = B[0];
	    
	    for(int i=1;i<N;i++){
	        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]+M)+A[i];
	        dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0]+M)+B[i];
	    }
	    
		System.out.println(Math.min(dp[N-1][0], dp[N-1][1]));
	}
}
