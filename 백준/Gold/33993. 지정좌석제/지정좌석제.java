import java.util.*;
import java.io.*;
public class Main
{
    static int N, R, C, W;
    static int dp[][];
    static int input[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    W = Integer.parseInt(st.nextToken());
	    
	    dp = new int[R+1][C+1];
	    input = new int[R+1][C+1];
	    
	    int y = 0, x = 0;
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        y = Integer.parseInt(st.nextToken());
	        x = Integer.parseInt(st.nextToken());
	        input[y][x] = 1;
	    }
	    
	    for(int i=1;i<=R;i++){
	        for(int j=1;j<=C;j++){
	            dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + input[i][j];
	        }
	    }
	    
	    int res = -1, sum1, sum2, sum3, sum4;
	    for(int i=1;i<=R;i++){
	        for(int j=1;j<=C;j++){
	            if(input[i][j] == 1) continue;
	            sum1 = dp[Math.max(0, i-W/2-1)][Math.max(0, j-W/2-1)];
	            sum2 = dp[Math.max(0, i-W/2-1)][Math.min(C, j+W/2)];
	            sum3 = dp[Math.min(R, i+W/2)][Math.max(0, j-W/2-1)];
	            sum4 = dp[Math.min(R, i+W/2)][Math.min(C, j+W/2)];
	            
	            if(sum4 - sum3 - sum2 + sum1 > res) {
	                res = sum4 - sum3 - sum2 + sum1;
	                y = i;
	                x = j;
	            } 
	        }
	    }
	    
	    sb.append(res).append("\n").append(y).append(" ").append(x);
	    
		System.out.print(sb);
	}
}
