import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		
		if(N==1){
		    System.out.print(br.readLine());
		    return;
		}
		
		for(int i=0;i<N;i++){
		    input[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(input);
		
		int answer = 0, i=0, j=N-1;
		for(;i<N-1;i+=2){
		    if(input[i+1]>0) break; 
		    answer += input[i]*input[i+1];
		}
		for(;j>0;j-=2){
		    if(input[j-1]<=1) break;
		    answer += input[j-1]*input[j];
		}
		for(;i<=j;i++)
		    answer += input[i];
		System.out.print(answer);
	}
}
