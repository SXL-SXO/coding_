import java.util.*;
import java.io.*;
public class Main
{
    static int T, N, answer = 0;
    static int input[], dp[][]; 
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        N = Integer.parseInt(br.readLine());
	        st = new StringTokenizer(br.readLine());
	        
	        input = new int[N+1];
	        dp = new int[N+2][N+1];
	        
	        for(int i=1;i<=N;i++) {
	            input[i] = Integer.parseInt(st.nextToken());
	        }
	        make();
            sb.append(dp[1][N]).append("\n");
	    }
	    
		System.out.println(sb);
	}
	static void make(){
	   // for(int i=0;i<N;i++) dp[i][i] = N%2==0 ? 0 : input[i];
	    
	    int r, c;
	    for(int i=1;i<=N;i++){
	        for(int j=1;i+j-1<=N;j++){
	            r = j;
	            c = i+j-1;
	            
	            
	            if((N-i)%2==0) dp[r][c] = Math.max(dp[r+1][c]+input[r], dp[r][c-1]+input[c]);
	            else dp[r][c] = Math.min(dp[r+1][c], dp[r][c-1]);
	        }
	    }
	}
}
