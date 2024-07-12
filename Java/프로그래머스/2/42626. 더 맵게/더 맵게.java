import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int solution(int[] scoville, int K) {
        int answer = 0;
        for(int s : scoville){
            pq.offer(s);
        }
        for(;;answer++){
            if(pq.peek()>=K) break;
            else if(pq.size()<=1){
                answer = -1;
                break;
            }
            
            pq.offer(pq.poll() + pq.poll()*2);
        }
        return answer;
    }
}