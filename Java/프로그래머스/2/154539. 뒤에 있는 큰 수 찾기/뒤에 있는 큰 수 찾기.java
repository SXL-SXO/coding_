import java.util.*;
class Solution {
    static Stack<Integer> stack = new Stack<>();
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[numbers.length-1] = -1;
        stack.push(numbers[numbers.length-1]);
        
        for(int i = numbers.length-2; i>=0 ; i--){
            while(!stack.isEmpty()){                
                if(numbers[i]<stack.peek()){
                    answer[i] = stack.peek();
                    break;
                }
                else
                    stack.pop();
            }
            if(answer[i]==0) answer[i] = -1;
            stack.push(numbers[i]);
        }
        return answer;
    }
    static class Node{
        int index, val;
        Node(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
}