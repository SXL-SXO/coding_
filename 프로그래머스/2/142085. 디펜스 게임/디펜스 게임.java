// 04:04
import java.util.*;

class Solution {
    static int life, N, K;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
    public int solution(int n, int k, int[] enemy) {
        life = n;
        N = enemy.length;
        K = k;
        
        if(N<=K) return N;
        
        int answer = N, count = 0;
        for(int i=0;i<N;i++) {
            life -= enemy[i];
            pq.offer(enemy[i]);
            
            while(life<0 && !pq.isEmpty() && count<K){
                life += pq.poll();
                count++;
            }
            // System.out.println(life+" "+i+" "+count);
            if(life<0) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
    //dp k*len = 500_000_000_000 시간초과
}