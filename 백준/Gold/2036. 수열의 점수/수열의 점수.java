import java.util.*;
import java.io.*;

public class Main
{
    static PriorityQueue<Integer> pq_plus = new PriorityQueue<>((o1,o2)->o2-o1);
    static PriorityQueue<Integer> pq_minus = new PriorityQueue<>((o1,o2)->o1-o2);
    static int N;
    static Long answer = 0L;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    int n3;
	    for(int i=0;i<N;i++){
	        n3 = Integer.parseInt(br.readLine());
	        if(n3 == 1) answer += 1;
	        else if(n3<=0) pq_minus.offer(n3);
	        else pq_plus.offer(n3);
	    }
	    int n1,n2;
	    while(pq_plus.size()>1){
	        n1 = pq_plus.poll();
	        n2 = pq_plus.poll();
	        answer += (long)n1*n2;
	    } 
	    while(pq_minus.size()>1){
	        n1 = pq_minus.poll();
	        n2 = pq_minus.poll();
	        answer += (long)n1*n2;
	    } 
	    if(!pq_plus.isEmpty()) answer += pq_plus.poll();
	    if(!pq_minus.isEmpty()) answer += pq_minus.poll();
	    
		System.out.println(answer);
	}
}
