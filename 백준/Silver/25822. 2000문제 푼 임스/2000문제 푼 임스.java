import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, max = 0, day = 0;
    static Queue<Integer> queue = new ArrayDeque<>();
    static int input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    M = (int) (Double.parseDouble(br.readLine())/0.99);
	    if(M>2) M = 2;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    input = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
	    
	    int count = 0;
	    for(int i=0;i<N;i++) {
	        if(input[i]==0){
	            if(count>=M) {
	                while(!queue.isEmpty() && queue.peek()!=0) queue.poll();
	                if(!queue.isEmpty()) {
	                    queue.poll();
	                    count--;
	                }
	            }
	            
	            if(count<M) {
	                count++;
	                queue.offer(input[i]);
	            }
	        }else queue.offer(input[i]);
	        
	        max = Math.max(max, input[i]);
	        day = Math.max(day, queue.size());
	    } 
	    
	    sb.append(day).append("\n").append(max);
	    
		System.out.println(sb);
	}
}
