import java.util.*;
class Solution {
    static boolean visit[];
    static Queue<Integer> queue = new ArrayDeque<>();
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
        int answer = -1, count = 0, size, temp;
        visit = new boolean[y-x+1];
        queue.offer(x);
        total : while(!queue.isEmpty()){
            size = queue.size();
            for(int i=0;i<size;i++){
                temp = queue.poll();
                if(temp==y) {
                    answer = count;
                    break total;
                }else if(temp>y) continue;
                
                if( visit[temp-x] ) continue;
                visit[temp-x] = true;
                
                queue.offer(temp+n);
                queue.offer(temp*2);
                queue.offer(temp*3);
            }
            count++;
        }
        return answer;
    }
    
}