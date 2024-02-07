import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i=0;i<10;i++){
            answer+=i;
        }
        for(int i=0;i<numbers.length;i++){
            answer-=numbers[i];
        }
        return answer;
    }
}