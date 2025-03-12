// 10:50
import java.util.*;
class Solution
{
    static Stack<Integer> stack = new Stack<>();
    public int solution(String s)
    {
        int answer;
        char input[] = s.toCharArray();
        
        for(char c:input){
            if(stack.isEmpty() || stack.peek()!=(int)c) stack.push((int)c);
            else stack.pop();
        }
        answer = stack.isEmpty() ? 1 : 0; 
            
        return answer;
    }
}