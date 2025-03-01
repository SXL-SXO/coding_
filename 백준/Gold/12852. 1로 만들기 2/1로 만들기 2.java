import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int dp[], num[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	    N = Integer.parseInt(br.readLine());
	    dp = new int[N+1];
	    
	    Arrays.fill(dp, N+1);
	    dp[N] = 0;
	    
	    for(int i=N;i>1;i--){
	        if(i%3==0 && dp[i/3]>dp[i]+1) dp[i/3] = dp[i]+1;
	        if(i%2==0 && dp[i/2]>dp[i]+1) dp[i/2] = dp[i]+1;
	        if(dp[i-1]>dp[i]+1) dp[i-1] = dp[i]+1;
	    }
	    
	    num = new int[dp[1]+1];
	    
	    int idx = 1, count = 0;
	    while(idx<N){
            num[count++] = idx;
	        if(idx*3<=N && dp[idx*3]==dp[idx]-1) idx*=3;
	        else if(idx*2<=N && dp[idx*2]==dp[idx]-1) idx*=2;
	        else idx+=1;
	    }
	    
	    sb.append(dp[1]).append("\n").append(N).append(" ");
	    for(int i=dp[1]-1;i>=0;i--) sb.append(num[i]).append(" ");
	    
	    System.out.print(sb);
	}
}
