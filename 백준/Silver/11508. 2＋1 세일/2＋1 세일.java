import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++) pq.offer(Integer.parseInt(br.readLine()));
	    
	    while(!pq.isEmpty()){
	        for(int i=0;i<2 && !pq.isEmpty();i++) answer += pq.poll();
	        if(!pq.isEmpty()) pq.poll();
	    }
	    
		System.out.println(answer);
	}
}
