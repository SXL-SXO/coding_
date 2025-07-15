//02:35
import java.util.*;
class Solution {
    static int answer = 0, N;
    public int solution(int[] people, int limit) {
        N = people.length;
        
        Arrays.sort(people);
        
        int start = 0;
        for(int end = N-1; end>=start; end--){
            if(people[start]+people[end]<=limit) start++;
            answer++;
        }
        
        return answer;
    }
}