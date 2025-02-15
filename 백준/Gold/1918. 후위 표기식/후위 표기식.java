import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static String input[];
    static Stack<StringBuilder> stack = new Stack<>();
    static Stack<StringBuilder> stack_temp = new Stack<>();
    static Stack<StringBuilder> stack_first = new Stack<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().split("");
	    N = input.length;
	    
	    for(int i=0;i<N;i++) {
	        if(input[i].equals(")")) remove();
	        else stack.push(new StringBuilder(input[i]));
	    }
	    
	 
	    stack_temp = stack;
	    stack = new Stack();
	    while(!stack_temp.isEmpty()) stack.push(stack_temp.pop());
	    
	    first(stack, stack_temp);
	    second(stack);
	    System.out.print(stack.pop());
	}
	static void remove(){
	    StringBuilder s1, s2, s3;
	    while(!stack.isEmpty()){
	        s1 = stack.pop();
	        
	        if(s1.toString().equals("(")) break;
	        else stack_temp.push(s1);
	    }
	    
	    first(stack_temp, stack_first);
	    second(stack_temp);
	    stack.push(stack_temp.pop());
	}
	// * / 먼저 변경, 반드시 위 아래 뒤집어진 stack이어야함
	static void first(Stack<StringBuilder> s, Stack<StringBuilder> s_temp){
	    StringBuilder s1, s2, s3;
	    
	    while(!s.isEmpty()){
	        s2 = s.pop();
	        if(isFirst(s2)){
	            s1 = s_temp.pop();
	            s3 = s.pop();
	            s_temp.push(s1.append(s3).append(s2));
	        } else s_temp.push(s2);
	        
	    }
	    
	    while(!s_temp.isEmpty()) s.push(s_temp.pop());
	}
	static boolean isFirst(StringBuilder sb){
	    return sb.toString().equals("/") || sb.toString().equals("*");
	}
	
	static void second(Stack<StringBuilder> s){
	    StringBuilder s1, s2, s3;
	    while(s.size()>2){
	        s1 = s.pop();
	        s2 = s.pop();
	        s3 = s.pop();
	       // System.out.print(s1+" "+s2+" "+s3);
	        s.push(s1.append(s3).append(s2));
	    }
	   // System.out.print(s.peek());
	}
}
