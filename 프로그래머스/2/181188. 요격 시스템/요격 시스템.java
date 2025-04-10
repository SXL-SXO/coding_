// 04:09~
import java.util.*;
class Solution {
    static int N;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.e==o2.e ? o1.s-o2.s : o1.e-o2.e);
    public int solution(int[][] targets) {
        N = targets.length;
        for(int i=0;i<N;i++){
            pq.offer(new Node(targets[i][0], targets[i][1]));
        }
        
        Node target = pq.poll(), temp;
        int answer = 1;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(temp.s>=target.e){
                answer++;
                // System.out.println(temp.s+" "+temp.e+" "+target.s+" "+target.e);
                target = temp;
            }else {
                target.s = Math.max(target.s, temp.s);
                target.e = Math.min(target.e, temp.e);
            }
        }
        
        return answer;
    }
    static class Node{
        int s, e;
        Node(int s, int e){
            this.s=s;
            this.e=e;
        }
    }
}