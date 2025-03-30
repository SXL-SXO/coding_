import java.util.*;
import java.io.*;
public class Main
{
    static int T, N;
    static char input[];
    static Stack<Character> stack = new Stack<>(), temp = new Stack<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        input = br.readLine().toCharArray();
	        
	        for(char c : input){
	            if(c=='-') {
	                if(!stack.isEmpty())stack.pop();
	            }else if(c=='<'){
	                if(!stack.isEmpty())temp.push(stack.pop());
	            }else if(c=='>'){
	                if(!temp.isEmpty()) stack.push(temp.pop());
	            }else{
	                stack.push(c);
	            }
	        }
	        
	        while(!stack.isEmpty()){
	            temp.push(stack.pop());
	        }
	        while(!temp.isEmpty()){
	            sb.append(temp.pop());
	        }
	        sb.append("\n");
	    }
	    
		System.out.println(sb);
	}
}
