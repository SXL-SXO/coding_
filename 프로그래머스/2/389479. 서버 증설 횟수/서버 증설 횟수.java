// 09:18~23, 35~
import java.util.*;
class Solution {
    static int answer = 0;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public int solution(int[] players, int m, int k) {
        queue.offer(24);
        while(players[0]>=queue.size()*m){
            queue.offer(k);
            answer++;
        }
        for(int i=1;i<24;i++){
            while(!queue.isEmpty() && queue.peek()<=i) queue.poll();
            while(players[i]>=queue.size()*m){
                queue.offer(i+k);
                answer++;
            }
            System.out.print(answer+" ");
        }
        
        return answer;
    }
}