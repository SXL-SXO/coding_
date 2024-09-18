import java.util.*;
import java.io.*;

public class Main
{
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static int T, K;
    static Long answer;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        K = Integer.parseInt(br.readLine());
    	    st = new StringTokenizer(br.readLine());
    	    for(int i=0;i<K;i++){
    	        pq.offer(Long.parseLong(st.nextToken()));
    	    }
    	    
    	    Long a, b;
    	    answer = 0L;
    	    while(pq.size()>=2){
    	        a = pq.poll();
    	        b = pq.poll();
    	        
    	        answer += a+b;
    	        pq.offer(a+b);
    	    }
    	    pq.poll();
    	    sb.append(answer).append("\n");
	    }
	    
		System.out.println(sb);
	}
}
