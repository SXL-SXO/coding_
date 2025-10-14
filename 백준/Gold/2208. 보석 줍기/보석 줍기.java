import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, answer = 0;
    static int dp[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1];
		for(int i=1;i<=N;i++) dp[i] = dp[i-1]+ Integer.parseInt(br.readLine());
		
		
		int min = 0;
		answer = Math.max(dp[M], 0);
		for(int i=M+1; i<=N; i++){
		    min = Math.min(min, dp[i-M]);
		    answer = Math.max(answer, dp[i]-min);
		}
		
		System.out.println(answer);
	}
}
