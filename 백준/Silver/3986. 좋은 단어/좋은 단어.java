import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    
	    N = Integer.parseInt(br.readLine());
	    
	    char input[];
	    total : for(int i=0;i<N;i++){
	        input = br.readLine().toCharArray();
	        for(int j=0;j<input.length;j++){
	            if(stack.isEmpty() || stack.peek()!=input[j]) stack.push(input[j]);
	            else stack.pop();
	        }
	        if(stack.isEmpty()) answer++;
	        else stack.clear();
	    }
	    
		System.out.println(answer);
	}
}
