import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 101;
        for(int i : array){
            if(Math.abs(n-i)==Math.abs(n-answer)){
                if (answer>i)
                    answer=i;
            }
            else if(Math.abs(n-i)<Math.abs(n-answer))
                answer=i;
        }
        return answer;
    }
}
