import java.util.*;
import java.io.*;
public class Main
{
    static int N, K;
    static int input[], dp[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    input = new int[N];
	    dp = new int[K+1];
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(br.readLine());
	        if(K>=input[i]) dp[input[i]] = 1;
	    }
	    Arrays.sort(input);
	    
	    int next;
	    for(int i=0;i<K;i++){
	        if(dp[i] == 0) continue;
	        for(int j=0;j<N;j++){
	            next = i+input[j];
	            if(next>K) continue;
	            
	            dp[next] = dp[next]==0 ? dp[i]+1 : Math.min(dp[next], dp[i]+1);
	        }
	    }
	    
	    if(dp[K]==0) System.out.print(-1);
	    else System.out.print(dp[K]);
	}
}
