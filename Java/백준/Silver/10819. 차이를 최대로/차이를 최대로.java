import java.io.*;
import java.util.*;

public class Main
{
    static int N, answer = 0;
    static int input[], sort_input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    input = new int[N];
	    sort_input = new int[N];
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	    }
	    for(int i=0;i<N;i++){
	        sort_input[0] = input[i];
	        fill_Array(1<<i, 1);
	    }
	    
		System.out.print(answer);
	}
	static void fill_Array(int visit, int count){
	    if(count==N) {
	        int sum = 0;
	        for(int i=0;i<N-1;i++){
	            sum += Math.abs(sort_input[i+1]-sort_input[i]);
	        }
	        answer = Math.max(answer, sum);
	        return;
	    }
	    for(int i=0; i<N;i++){
	        if((visit & (1<<i))!=0) continue;
	        sort_input[count] = input[i];
	        fill_Array(visit | 1<<i, count+1);
	    }
	}
}
