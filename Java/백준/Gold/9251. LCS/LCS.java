import java.util.*;
import java.io.*;
public class Main
{
    static char[] input_1, input_2;
    static int dp[][];
    static int len_1, len_2, answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input_1 = br.readLine().toCharArray();
		input_2 = br.readLine().toCharArray();
		
		len_1 = input_1.length;
		len_2 = input_2.length;
		
		dp = new int[len_1+1][len_2+1];
		for(int i=1; i<=len_1; i++){
		    dp[i][1] = dp[i-1][1];
		    for(int j=1; j<=len_2; j++){
		        if(input_1[i-1]==input_2[j-1]) dp[i][j] = dp[i-1][j-1]+1;
		        else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
		    }
		}
		System.out.print(dp[len_1][len_2]);
	}
}
