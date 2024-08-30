import java.util.*;
import java.io.*;

public class Main
{
    static int T, N, M, answer;
    static int dp[][], coin[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++){
		    N = Integer.parseInt(br.readLine());
		    coin = new int[N+1];
		    
		    st = new StringTokenizer(br.readLine());
		    M = Integer.parseInt(br.readLine());
		    dp = new int[M+1][N];
		    
		    for(int i=0;i<N;i++){
		        coin[i] = Integer.parseInt(st.nextToken());
		        if(coin[i]>M) continue;
		        dp[coin[i]][i] = 1;
		    }
		    
		    for(int i=1;i<M;i++){
		        for(int j=0;j<N;j++){
		            if(dp[i][j]<1) continue;
		            for(int k=j;k<N;k++){
		                if(i+coin[k]>M) break;
		                dp[i+coin[k]][k] += dp[i][j];
		            }
	                
		        }
		    }
		  //  System.out.print(Arrays.toString(dp
		    answer = 0;
		    for(int i=0;i<N;i++) answer += dp[M][i];
            sb.append(answer).append("\n");
		}
		
		System.out.print(sb);
	}
}
