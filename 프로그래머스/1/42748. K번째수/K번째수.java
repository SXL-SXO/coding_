//04:45~
import java.util.*;
class Solution {
    static int N, M;
    static int answer[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(int[] array, int[][] commands) {
        N = array.length;
        M = commands.length;
        answer = new int[M];
        
        for(int i=0;i<M;i++){
            for(int j=commands[i][0]; j<=commands[i][1]; j++){
                pq.offer(array[j-1]);
            }
            for(int j=1;j<commands[i][2];j++){
                pq.poll();
            }
            answer[i] = pq.poll();
            pq.clear();
        }
        
        return answer;
    }
}