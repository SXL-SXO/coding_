import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
	static PriorityQueue<Integer> out = new PriorityQueue<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
	    M = Integer.parseInt(br.readLine());
	    pq.offer(M);
	    sb.append(M).append("\n");
	    
		for(int i=1;i<N;i++){
		    M = Integer.parseInt(br.readLine());
		    
		    if(pq.peek()>M) {
		        out.offer(pq.poll());
		        pq.offer(M);
		    }else out.offer(M);
		    
		    if(i%2 == 0) pq.offer(out.poll());
		    sb.append(pq.peek()).append("\n");
		}
		System.out.print(sb);
	}
}
