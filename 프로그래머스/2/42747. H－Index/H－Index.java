// 04:43
import java.util.*;
class Solution {
    static int N, answer;
    public int solution(int[] citations) {
        answer = N = citations.length;
        
        // 0 1 3 5 6
        // 	[2, 4, 7, 10, 15, 16, 19, 20, 25, 27]
        Arrays.sort(citations);
        for(int i=N-1;i>=0;i--){
            if(citations[i]<N-i) {
                answer = N-i-1;
                break;
            }
        }
        
        return answer;
    }
}