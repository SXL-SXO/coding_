import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = 0;
    static int input[], dp[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[N];
	    dp = new int[N][3];
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(br.readLine());
	    }
	    
	    if(N==1){
    	    System.out.print(input[0]);
    	    return;
	    }else if(N==2){
	        System.out.print(input[1]+input[0]);
    	    return;
	    }
	    
	    dp[0][1] = input[0];
	    
	    dp[1][0] = input[0];
	    dp[1][1] = input[1];
	    dp[1][2] = input[0]+input[1];
	    
	    for(int i=2;i<N;i++){
	        dp[i][0] = Math.max(Math.max(dp[i-1][2], dp[i-1][1]), Math.max(dp[i-2][2], dp[i-2][1]));
	        dp[i][1] = dp[i-1][0] + input[i];
	        dp[i][2] = dp[i-1][1] + input[i];
	    }
	    
		System.out.println(Math.max(Math.max(dp[N-1][2], dp[N-1][1]), dp[N-1][0]));
	}
}
