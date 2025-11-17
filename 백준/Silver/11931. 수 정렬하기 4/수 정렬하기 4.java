import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++) pq.offer(Integer.parseInt(br.readLine()));
	    
    	for(int i=0;i<N;i++) sb.append(pq.poll()).append("\n");
	    
		System.out.println(sb);
	}
}
