import java.util.*;
class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        answer = 1+(k-1)*2%numbers.length;
        return answer;
    }
}