import java.util.*;
class Solution {
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> (o1.count-o2.count));
    public int solution(int storey) {
        int answer = 0;
        
        pq.offer(new Node(storey, 0));
        if(storey%10!=0) pq.offer(new Node(storey/10+1,10-storey%10));
        
        Node temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(temp.num>100_000_000 || temp.num<0) continue;
            else if(temp.num == 0){
                answer = temp.count;
                break;
            }
            pq.offer(new Node(temp.num/10, temp.count+temp.num%10));
            if(temp.num%10!=0) pq.offer(new Node(temp.num/10+1,temp.count+10-temp.num%10));
        }
        
        return answer;
    }
    static class Node{
        int num, count;
        Node(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
    static int len(int num){
        int i = 1, j = 10;
        for(;i<9;i++){
            if(num<j) break;
            j*=10;
        }
        return i-1;
    }
}