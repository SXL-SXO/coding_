// 08:17
import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int temp1, temp2, answer = 0;
        
        for(int s : scoville) pq.offer(s);
        while(pq.size()>1 && pq.peek()<K){
            answer++;
            temp1 = pq.poll();
            temp2 = pq.poll();
            
            if((long)temp2*2+(long)temp1 - (long)Integer.MAX_VALUE>0) pq.offer(Integer.MAX_VALUE);
            else pq.offer(temp1+temp2*2);
        }
        if(pq.isEmpty()||pq.peek()<K) answer = -1;
        return answer;
    }
}