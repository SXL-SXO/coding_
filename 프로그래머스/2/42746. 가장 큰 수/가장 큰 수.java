// 01:18
import java.util.*;
class Solution {
    static int zero = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.num==o1.num ? o2.n-o1.n : o2.num-o1.num);
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] numbers) {
        // 9 900 -> 9900
        // 1 150 -> 1510
        
        // 17 1 -> 171
        // 71 7 -> 771
        
        for(int n : numbers) {
            if(n==0){
                zero++;
                pq.offer(new Node(0, 0));
            }else if(n==1000){
                pq.offer(new Node(n, 10000));
            }else if(n<10){
                pq.offer(new Node(n, n*10000+n*1000+n*100+n*10+n));
            }else if(n<100){
                pq.offer(new Node(n, n*1000+n*10+n/10));
            }else {
                pq.offer(new Node(n, n*100+n/10*10));
            }
        }
        while(!pq.isEmpty()) sb.append(pq.poll().n);
        
        if(zero == numbers.length) return "0";
        return sb.toString();
    }
    static class Node{
        int n, num;
        
        Node(int n, int num){
            this.n=n;
            this.num=num;
        }
    }
}