import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int input[];
    static int dp[][];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    if(N==1){
	        System.out.print(0);
	        return;
	    }
	    
	    input = new int[N+1];
	    dp = new int[N+1][N+1];
	    
	    st = new StringTokenizer(br.readLine());
        input[0] = Integer.parseInt(st.nextToken());
        
	    for(int i=1;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    input[N] = Integer.parseInt(st.nextToken());
	    
	    for(int i=2;i<=N;i++){
	        dp[i-2][i] = input[i-2]*input[i-1]*input[i];
	    }
	    
	    for(int j=3;j<=N;j++){
	        for(int i=0;i+j<=N;i++){
	           // System.out.println(input[i]*input[i+k-1]*input[i+k]+dp[i][i+k-1]);
	           // System.out.println(input[i]*input[i+1]*input[i+k]+dp[i+1][i+k]);
	           
	            dp[i][i+j] = Math.min(input[i]*input[i+j-1]*input[i+j]+dp[i][i+j-1] , input[i]*input[i+1]*input[i+j]+dp[i+1][i+j]);
	            for(int k=2;k<j-1;k++){
	                dp[i][i+j] = Math.min(dp[i][i+j], dp[i][i+k] + dp[i+k][i+j] + input[i]*input[i+k]*input[i+j]);
	            }
	        }
	    }
	    
	    System.out.print(dp[0][N]);
	    
	}
}
