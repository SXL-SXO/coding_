import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, C, D, answer = 0;
    static int dp[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    D = Integer.parseInt(st.nextToken());
	    
	    dp = new int[N+1];
	    
	    int a, b, c, d, e;
	    for(int i=1;i<=N/C;i++){
	        dp[N-C*i] = D*i;
	    }
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        d = Integer.parseInt(st.nextToken());
	        
	        e = a/b;
	        for(int j=0; j<N; j++){
	            for(int k=e; k>0; k--){
    	            if(j+k*c>N) continue;
    	            dp[j] = Math.max(dp[j], dp[j+k*c] + d*k);
    	        }
	        }
	    }
	    for(int i=0;i<=N;i++) answer = Math.max(answer, dp[i]);
		System.out.println(answer);
	}
}
