import java.util.*;
import java.io.*;
public class Main
{
    static char[] input_1, input_2;
    static boolean dp[][];
    static int len_1, len_2, answer = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input_1 = br.readLine().toCharArray();
		input_2 = br.readLine().toCharArray();
		
		len_1 = input_1.length;
		len_2 = input_2.length;
		
		dp = new boolean[len_1][len_2];
		for(int i=len_1-1; i>=0; i--){
		    for(int j=len_2-1; j>=0; j--){
		        if(input_1[i]==input_2[j]) dp[i][j] = true;
		    }
		}
		
		for(int i=0;i<len_1;i++){
		    for(int j=0;j<len_2;j++){
		        if(dp[i][j]) answer = Math.max(answer,check(i,j));
		    }
		}
		System.out.print(answer);
	}
	
	static int check(int a, int b){
	    int count = 0;
	    while(a<len_1 && b<len_2){
	        if(!dp[a][b]) break;
	        dp[a++][b++] = false;
	        count++;
	    }
	    return count;
	}
}
