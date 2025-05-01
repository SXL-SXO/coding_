import java.util.*;
import java.io.*;

public class Main
{
    static int N = 0, answer;
    static int dp[][]; // 시작버튼 / 1 / 6 / 60
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String input[] = br.readLine().split("");
	    N += 60 * Integer.parseInt(input[0]);
	    N += 6 * Integer.parseInt(input[1]);
	    N += Integer.parseInt(input[3]);
	    
	    if(N==1) answer = 2;
	    else if(N==2) answer = 3;
	    else {
    	    dp = new int[N+1][4];
    	    
    	    for(int i=1;i<=N;i++){
    	        Arrays.fill(dp[i], 1000000);
    	    }
    	    dp[1][0] = 2;
    	    dp[3][1] = 1;
    	    if(N>=6) dp[6][2] = 2;
    	    if(N>=60) dp[60][3] = 2;
    	    for(int i=2;i<=N;i++){
    	        dp[i][0] =  Math.min(Math.min(dp[i-1][0], dp[i-1][1]), Math.min(dp[i-1][2], dp[i-1][3]))+1;
    	        if(i>3) dp[i][1] = Math.min(Math.min(dp[i-3][0], dp[i-3][1]), Math.min(dp[i-3][2], dp[i-3][3]))+1;
    	        if(i>6) dp[i][2] = Math.min(Math.min(dp[i-6][0], dp[i-6][1]), Math.min(dp[i-6][2], dp[i-6][3]))+1;
    	        if(i>60) dp[i][3] = Math.min(Math.min(dp[i-60][0], dp[i-60][1]), Math.min(dp[i-60][2], dp[i-60][3]))+1;
    	    
    	    }
    	    
    	    answer = Math.min(Math.min(dp[N][0], dp[N][1]), Math.min(dp[N][2], dp[N][3]));
		
		}
		System.out.println(answer);
	}
}
