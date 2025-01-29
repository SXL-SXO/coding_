import java.util.*;
import java.io.*;
public class Main
{
    static int T, N, K;
    static int input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++){
    		st = new StringTokenizer(br.readLine());
    		N = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		
    		input = new int[N];
    		st = new StringTokenizer(br.readLine());
    		for(int i=0;i<N;i++){
    		    input[i] = Integer.parseInt(st.nextToken());
    		}
    		
    		Arrays.sort(input);
    		
    		check();
		}
		
		System.out.print(sb);
	}
	static void check(){
	    int front = 0, back = N-1, count = 1, value = 2_000_001, sum;
	    int diff;
	    while(front<back){
	        sum = input[front]+input[back];
	        diff = sum-K;
	        
	        if(Math.abs(diff)<value){
	            value = Math.abs(diff);
	            count = 1;
	        }else if(Math.abs(diff)==value) count++;
	        
	        if(diff<0) front++;
	        else if(diff>0) back--;
	        else {
	            if(input[front+1]-input[front]<input[back]-input[back-1]) front++;
	            else back--;
	        }
        }
        sb.append(count).append("\n");
	}
}
