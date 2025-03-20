// 07:04~
import java.util.*;
class Solution {
    static int N, start, end;
    public int solution(int[] people, int limit) {
        int answer = 0;
        N = people.length;
        start = 0;
        end = N-1;
        
        Arrays.sort(people);
        while(start<end) {
            if(people[start]+people[end]<=limit) {
                start++;
                end--;
            }else end--;
            answer++;
        }
        if(start==end) answer++;
        return answer;
    }
}