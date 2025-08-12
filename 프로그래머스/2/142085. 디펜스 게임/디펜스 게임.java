// 06:21
import java.util.*;
class Solution {
    static int N, K, answer = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
    public int solution(int n, int k, int[] enemy) {
        answer = N = enemy.length;
        
        int life = n, K = k;
        for(int i=0;i<N;i++){
            life -= enemy[i];
            pq.offer(enemy[i]);
            
            while(!pq.isEmpty() && life<0 && K>0) {
                life += pq.poll();
                K--;
            }
            
            // System.out.println(life +" "+ K);
            if(life<0) {
                answer = i;
                break;
            }
        }
        
        
        
        return answer;
    }
}