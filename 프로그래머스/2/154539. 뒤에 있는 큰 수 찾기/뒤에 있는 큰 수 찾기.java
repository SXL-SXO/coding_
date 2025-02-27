// 시작시간 06:13
import java.util.*;
class Solution {
    static Stack<Integer> stack = new Stack<>();
    static int n;
    public int[] solution(int[] numbers) {
        n = numbers.length;
        
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=numbers[i]){
                stack.pop();
            }
            if(stack.isEmpty()) stack.push(numbers[i]);
            else {
                answer[i] = stack.peek();
                stack.push(numbers[i]);
            }
        }
        
        return answer;
    }
}