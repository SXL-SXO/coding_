import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = 0;
    static int sum[];
    static char input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    N = input.length;
	    
	    sum = new int[N+1];
	    for(int i=1;i<=N;i++){
	        sum[i] = sum[i-1] + input[i-1]-'0';
	    }
	    
	    // i 길이
	    // j 중간 위치
	    // k 시작위치-1
	    
	    
// 		System.out.println(Arrays.toString(sum));
	    total : for(int i=N/2;i>0;i--){
	        for(int j=i+1; i+j<=N+1; j++){
	            int k = j-i-1;
	           // System.out.println(i +" " +sum[j+i-1] +" "+ sum[j-1] +" "+ sum[k]);
	            if(sum[j+i-1] - sum[j-1] == sum[j-1] - sum[k]) { answer = i*2; break total; }
	        }
	    }
		System.out.println(answer);
	}
}
