// 2:50
import java.util.*;
class Solution {
    static int N, idx;
    static Stack<Character> stack = new Stack<>();
    public int solution(String s) {
        int answer = 0;
        char input[] = s.toCharArray();
        char temp;
        N = s.length();
        total : for(int i=0;i<N;i++){
            stack.clear();
            idx = i;
            for(int j=0;j<N;j++){
                idx %= N;
                if(input[idx]=='(' || input[idx]=='[' || input[idx]=='{') stack.push(input[idx]);
                else if(input[idx]==')') {
                    if(stack.isEmpty() || stack.peek()!='(') continue total;
                    else stack.pop();
                }
                else if(input[idx]==']'){
                    if(stack.isEmpty() || stack.peek()!='[') continue total;
                    else stack.pop();
                }
                else if(input[idx]=='}'){
                    if(stack.isEmpty() || stack.peek()!='{') continue total;
                    else stack.pop();
                }
                idx++;
            }
            if(stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}