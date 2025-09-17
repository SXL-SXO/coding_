import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static long answer = 0;
    static char input[];
    static long dp[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    N = input.length;
	    
	    dp = new long[N][N];
	    dp[0][0] = 1;
	    for(int i=1;i<N;i++) {
	        dp[i][i] = 1;
	        dp[i-1][i] = input[i-1] == input[i] ? 1 : 0;
	    }
	    
	    // 차이나는  
	    for(int d=2;d<N;d++){
	        for(int i=0;i+d<N;i++){
	            if(input[i]==input[i+d]){
	                dp[i][i+d] = 1;
	                for(int a=i+1;a<i+d;a++){
	                    for(int b=a;b<i+d;b++){
	                        dp[i][i+d] += dp[a][b];
	                    }
	                }
	            }
	        }
	    }
	    
	    for(int i=0;i<N;i++){
	        for(int j=i;j<N;j++){
	           // System.out.println(i+" "+j+" "+dp[i][j]);
	            answer += dp[i][j];
	        }
	    }
	    
	    System.out.print(answer);
	}
}
