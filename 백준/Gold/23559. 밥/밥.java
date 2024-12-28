import java.util.*;
import java.io.*;

public class Main
{
    static int N, X, answer = 0, cost = 0;
    static Integer input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    cost = N*1000;
	    
	    input = new Integer[N];
	    
	    Integer A, B;
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        A = Integer.parseInt(st.nextToken());
	        B = Integer.parseInt(st.nextToken());
	        
	        answer += B;
	        input[i] = A-B;
	    }
	    Arrays.sort(input, Collections.reverseOrder());
	    
	    for(int a : input){
    	    if(a<0 || cost+4000>X) break; 
    	    answer += a;
    	    cost += 4000;
	    }
	    
		System.out.println(answer);
	}
}
