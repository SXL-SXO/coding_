import java.util.*;
import java.io.*;
public class Main
{
    static int N, K;
    static int input[];
    static int dp[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    if(K==0) {
	        System.out.print(0);
	        return;
	    }
	    
	    input = new int[N];
	    dp = new int[K+1];
	    Arrays.fill(dp, 101);
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	        if(input[i]<=K) {
	            if(dp[input[i]] == 101) dp[input[i]] = 0;
	            dp[input[i]]++;
	        }
	        
	    }
	    
	    Arrays.sort(input);
	   // System.out.println(Arrays.toString(dp));/
	    for(int i=0;i<N;i++){
	        for(int j=0;K-input[i]-j>=0;j++){
	            dp[K-j] = Math.min(dp[K-j], dp[K-input[i]-j]+1);
	        }
	    }
	    
	   // System.out.println(Arrays.toString(dp));
	    System.out.print(dp[K]==101 ? -1 : dp[K]);
	}
}
