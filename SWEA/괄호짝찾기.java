import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        StringBuilder sb =  new StringBuilder();
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            boolean check = true;
            int temp = sc.nextInt();
			char in[] = sc.next().toCharArray();
            Deque<String> stack = new ArrayDeque<>();
            sb.append("#").append(test_case).append(" ");
            for(int i =0;i<in.length;i++){
            	if(in[i]=='<' || in[i]=='[' || in[i]=='{' || in[i]=='('){
                    stack.push(in[i]+"");
                }else if(stack.isEmpty()){
                    check = false;
                    break;
                }else{
                	if(in[i]=='>' && stack.peek().equals("<")) stack.pop();
                    else if(in[i]==']' && stack.peek().equals("[")) stack.pop();
                    else if(in[i]=='}' && stack.peek().equals("{")) stack.pop();
                    else if(in[i]==')' && stack.peek().equals("(")) stack.pop();
                    else{
                    	check = false;
                    	break;
                	}
                }
            }
            if(check) sb.append(1).append("\n");
            else sb.append(0).append("\n");
            
        }
        System.out.print(sb.toString());
	}
}