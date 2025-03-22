import java.util.*;
import java.io.*;
public class Main
{
    static int N, temp;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    
		    temp = Integer.parseInt(st.nextToken());
		    if(temp == 1) stack.push(Integer.parseInt(st.nextToken()));
		    else if(temp == 2){
		        if(stack.isEmpty()) sb.append("-1\n");
		        else sb.append(stack.pop()).append("\n");
		    }else if(temp == 3) sb.append(stack.size()).append("\n");
		    else if(temp == 4) {
		        if(stack.isEmpty()) sb.append("1\n");
		        else sb.append("0\n");
		    }else if(temp == 5){
		        if(stack.isEmpty()) sb.append("-1\n");
		        else sb.append(stack.peek()).append("\n");
		    }
		}
		
		System.out.println(sb);
	}
}
