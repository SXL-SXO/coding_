import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, answer = 0;
    static int dp[][], input[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new int[N+1][M+1];
	    dp = new int[N+1][M+1];
	    
	    char temp[];
	    for(int i=1;i<=N;i++) {
            temp = br.readLine().toCharArray();
	        for(int j=1;j<=M;j++) {
	            input[i][j] = temp[j-1]-'0';
	            dp[i][j] = input[i][j];
	            answer |= dp[i][j];
	        }
	    }
	    
	    for(int i=1;i<=N;i++){
	        for(int j=1;j<=M;j++){
	            if(dp[i-1][j-1] == 0 || input[i][j] == 0) continue;
	            else if(dp[i-1][j-1]>=N || dp[i-1][j-1]>=M) dp[i][j] = check(i, j, dp[i-1][j-1]-1);
	            else  dp[i][j] = check(i, j, dp[i-1][j-1]);
	            
	            answer = Math.max(answer, dp[i][j]*dp[i][j]);
	        }
	       // System.out.println(Arrays.toString(dp[i]));
	    }
	    
		System.out.println(answer);
	}
	
	static int check(int a, int b, int size){
	    int res = 1;
	    for(int i=1;i<=size;i++){
	        res &= input[a-i][b] & input[a][b-i];
	        if(res == 0) return i;
	    }
	    return size+1;
	}
}
