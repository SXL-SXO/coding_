import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, min, max, answer = 0;
    static int input[], len[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken())-1;
		
		input = new int[N];
		len = new int[N-1];
		
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(br.readLine());
		Arrays.sort(input);
		
		for(int i=0;i<N-1;i++) len[i] = input[i+1]-input[i];
		
		min = 0;
		max = (input[N-1]-input[0])/M ;
		
		int count, sum, middle=(min+max+1)/2;
		while(min<middle && middle<max){
		    count = 0;
		    sum = 0;
		    
		    for(int i=0;i<N-1;i++){
		        if(sum+len[i]<middle) sum += len[i];
		        else{
		            sum=0;
		            count++;
		        }
		    }
		    
		    
		    if(count>=M) min = middle;
		    else max = middle;
		    
		    middle = (min+max+1)/2;
		}
		
		count = 0;
	    sum = 0;
	    
	    for(int i=0;i<N-1;i++){
	        if(sum+len[i]<max) sum += len[i];
	        else{
	            sum=0;
	            count++;
	        }
	    }
	    if(count>=M) answer = max;
	    else answer = min;
	    
	    System.out.print(answer);
	}
}
