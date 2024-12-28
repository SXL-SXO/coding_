import java.util.*;
import java.io.*;

public class Main
{
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
    static int N, X, answer = 0, cost = 0;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    cost = N*1000;
	    
	    int A, B;
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        A = Integer.parseInt(st.nextToken());
	        B = Integer.parseInt(st.nextToken());
	        
	        answer += B;
	        if(A>B) pq.offer(A-B);
	    }
	    while(!pq.isEmpty() && cost+4000<=X){
    	    answer += pq.poll();
    	    cost += 4000;
	    }
	    
		System.out.println(answer);
	}
}
