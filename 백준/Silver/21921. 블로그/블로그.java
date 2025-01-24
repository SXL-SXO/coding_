import java.util.*;
import java.io.*;

public class Main
{
	static int N, M, end;
	static int input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		input = new int[N];
		
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int sum = 0, max = 0, count = 1;
		end = M;
		for(int i=0;i<M;i++){
		    sum += input[i];
		}
		
		while(end < N){
		    if(sum > max) {
		        max = sum;
		        count = 1;
		    }else if(sum==max) count++;
		    
		    sum = sum - input[end-M] + input[end++];
		}
		if(sum > max) {
	        max = sum;
	        count = 1;
	    }else if(sum==max) count++;
	    
		if(max == 0) sb.append("SAD");
		else sb.append(max).append("\n").append(count);
		System.out.print(sb);
	}
}
