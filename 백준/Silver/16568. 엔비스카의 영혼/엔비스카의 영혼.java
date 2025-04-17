import java.util.*;
import java.io.*;
public class Main
{
    static int answer = 0, N, small, big;
    static int dp[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    small = Integer.parseInt(st.nextToken())+1;
		big = Integer.parseInt(st.nextToken())+1;
		
		if(small>big){
		    int temp = small;
		    small = big;
		    big = temp;
		}
		
		dp = new int[N+1][3];
		for(int i=1;i<=N;i++) Arrays.fill(dp[i], N+1);
		
		for(int i=1;i<=N;i++){
		    if(i>=big){
		        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]);
		        dp[i][0] = Math.min(dp[i][0], dp[i-1][2])+1;
		        
		        dp[i][1] = Math.min(dp[i-small][0], dp[i-small][1]);
		        dp[i][1] = Math.min(dp[i][1], dp[i-small][2])+1;
		        
		        dp[i][2] = Math.min(dp[i-big][0], dp[i-big][1]);
		        dp[i][2] = Math.min(dp[i][2], dp[i-big][2])+1;
		        
		    }else if(i>=small) {
		        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]);
		        dp[i][0] = Math.min(dp[i][0], dp[i-1][2])+1;
		       
		        dp[i][1] = Math.min(dp[i-small][0], dp[i-small][1]);
		        dp[i][1] = Math.min(dp[i][1], dp[i-small][2])+1;
		    }else{
		        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]);
		        dp[i][0] = Math.min(dp[i][0], dp[i-1][2])+1;
		    }
		}
		
// 		for(int i=0;i<=N;i++){
// 		    System.out.println(Arrays.toString(dp[i]));
// 		}
		answer = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);
		System.out.print(answer);
	}
}
