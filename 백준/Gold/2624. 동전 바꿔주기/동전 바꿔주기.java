import java.util.*;
import java.io.*;

public class Main
{
	static int T, N;
	static int dp[], input[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
	    N = Integer.parseInt(br.readLine());
	    
	    input = new int[N][2];
	    dp = new int[T+1];
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        
	        input[i][0] = Integer.parseInt(st.nextToken());
	        input[i][1] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(input, (o1, o2) -> o2[0]-o1[0]);
	    
	    for(int k=0;k<=input[0][1];k++){
	        if(input[0][0]*k>T) break;
	        dp[input[0][0]*k] = 1;
	    }
	    
	    for(int i=1;i<N;i++){
	        for(int j=T-input[i][0]; j>=0; j--){
	            if(dp[j] != 0) {
	                for(int k=input[i][1]; k>0; k--){
	                    if(j+input[i][0]*k>T) continue;
	                    dp[j+input[i][0]*k] += dp[j];
	                }
	            }
	        }
	    }
	    
	    System.out.print(dp[T]);
    }
}
