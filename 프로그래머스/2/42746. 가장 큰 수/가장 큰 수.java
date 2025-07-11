import java.util.*;
class Solution {
    static PriorityQueue<Node> pq = new PriorityQueue<>(
        (o1, o2) -> o2.s.compareTo(o1.s));
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] numbers) {
        
        int zero = 0;
        for(int n:numbers){
            if(n!=0) sb.append(n).append(n).append(n).append(n);
            else {
                zero++;
                sb.append(0);
            }
            pq.offer(new Node(n, sb.toString()));
            sb.setLength(0);
        }
        
        if(zero == numbers.length) return "0";
        
        while(!pq.isEmpty()) sb.append(pq.poll().num);
        
        return sb.toString();
    }
    static class Node{
        String s;
        int num;
        Node(int num, String s){
            this.num = num;
            this.s = s;
        }
    }
}