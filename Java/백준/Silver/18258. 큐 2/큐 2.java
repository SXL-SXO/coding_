import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    
	    String input;
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input = st.nextToken();
	        
	        switch(input){
	            case "push" : queue.offer(Integer.parseInt(st.nextToken())); break;
	            case "pop" : if(!queue.isEmpty()) sb.append(queue.poll()).append("\n"); else sb.append(-1).append("\n"); break;
	            case "size" : sb.append(queue.size()).append("\n"); break; 
	            case "empty" : if(!queue.isEmpty()) sb.append(0).append("\n"); else sb.append(1).append("\n"); break;
	            case "front" : if(!queue.isEmpty()) sb.append(queue.peek()).append("\n"); else sb.append(-1).append("\n"); break;
	            case "back" :if(!queue.isEmpty()) sb.append(queue.peekLast()).append("\n"); else sb.append(-1).append("\n"); break;
	        }
	    }
		System.out.print(sb);
	}
}
