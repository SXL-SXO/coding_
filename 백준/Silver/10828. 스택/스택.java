import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   
	   Deque<Integer> stack = new ArrayDeque<>();
	   StringBuilder sb = new StringBuilder();
	   int N = Integer.parseInt(br.readLine());
	   StringTokenizer st;
	   while(N-- > 0){
	       st = new StringTokenizer(br.readLine());
	       String exec = st.nextToken();
	       if(exec.equals("push")) {stack.push(Integer.parseInt(st.nextToken()));
	            continue;
	           
	       }
	       
	       else if(exec.equals("pop")) sb.append(stack.isEmpty() ? -1 : stack.pop());
	       else if(exec.equals("size")) sb.append(stack.size());
	       else if(exec.equals("empty")) sb.append(stack.isEmpty() ? 1 : 0);
	       else sb.append(stack.isEmpty() ? -1 : stack.peek());
	       sb.append('\n');
	   }
	   System.out.println(sb);
	}
}
