// 02:54 ~ 03:12
import java.util.*;
class Solution {
    static int N, K, answer = 1;
    static int cost[];
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
    static List<List<Node>> list = new ArrayList<>();
    public int solution(int n, int[][] road, int k) {
        N = n;
        K = k;
        
        cost = new int[N+1];
        Arrays.fill(cost, 500001);
        visit = new boolean[N+1];
        
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        
        for(int r[] : road){
            list.get(r[0]).add(new Node(r[1], r[2]));
            list.get(r[1]).add(new Node(r[0], r[2]));
        }

        dijistra();
        check();

        return answer;
    }
    static void check(){
        for(int i=2;i<=N;i++){
            if(cost[i]<=K) answer++;
        }
    }
    static void dijistra(){
        pq.offer(new Node(1, 0));
        cost[1] = 0;
        
        Node temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            
            if(visit[temp.idx]) continue;
            visit[temp.idx] = true;
            
            for(Node n : list.get(temp.idx)){
                if(cost[temp.idx]+n.val < cost[n.idx]){
                    pq.offer(new Node(n.idx, cost[temp.idx]+n.val));
                    cost[n.idx] = cost[temp.idx]+n.val;
                }
            }
        }
        
        // System.out.print(Arrays.toString(cost));
    }
    static class Node{
        int idx, val;
        Node(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
}