import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int input[][], dp[][][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new int[N][M];
	    dp = new int[N][M][3];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<M;j++){
	            input[i][j] = Integer.parseInt(st.nextToken());
	            Arrays.fill(dp[i][j], 100000001);
	        }
	    }
	    for(int j=0;j<M;j++){
            dp[0][j][0] = input[0][j];
            dp[0][j][1] = input[0][j];
            dp[0][j][2] = input[0][j];
        }
        
        //0 -1에게서 온 것
        //1 0에게서 온 것
        //2 +1에게서 온 것
        for(int i=1;i<N;i++){
            dp[i][0][1] = dp[i-1][0][2]+input[i][0];
            dp[i][0][2] = Math.min(dp[i-1][1][0], dp[i-1][1][1])+input[i][0];
	        for(int j=1;j<M-1;j++){
	            dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2])+input[i][j];
	            dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2])+input[i][j];
	            dp[i][j][2] = Math.min(dp[i-1][j+1][0], dp[i-1][j+1][1])+input[i][j];
	        }
	        dp[i][M-1][0] = Math.min(dp[i-1][M-2][1], dp[i-1][M-2][2])+input[i][M-1];
	        dp[i][M-1][1] = dp[i-1][M-1][0]+input[i][M-1];
	    }
        
        int answer = Math.min(dp[N-1][0][1], dp[N-1][0][2]);
	    for(int j=1;j<M-1;j++){
            answer = Math.min(dp[N-1][j][0], answer);
            answer = Math.min(dp[N-1][j][1], answer);
            answer = Math.min(dp[N-1][j][2], answer);
        }
        answer = Math.min(answer, dp[N-1][M-1][1]);
        answer = Math.min(answer, dp[N-1][M-1][0]);
		System.out.print(answer);
	}
}
