import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = 0;
    static int input[][], dp[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[N+1][N+1];
	    dp = new int[N+1][N+1];
	    for(int i=1;i<=N;i++){
	        st = new StringTokenizer(br.readLine());
	        
	        for(int j=1;j<=i;j++){
	            input[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i=1;i<=N;i++){
	        for(int j=1;j<=i;j++){
	            dp[i][j] = input[i][j]+Math.max(dp[i-1][j-1],dp[i-1][j]);
	        }
	    }
	    
	   // for(int i=0;i<=N;i++) System.out.println(Arrays.toString(dp[i]));
	    for(int i=0;i<=N;i++){
	        answer = Math.max(answer, dp[N][i]);
	    }
		System.out.println(answer);
	}
}
