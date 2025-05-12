// 11:40

import java.util.*;
class Solution {    
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.end==o2.end ? o1.start-o2.start : o1.end-o2.end));
    static int answer = 0;
    public int solution(String[][] book_time) {        
        String temp_1[], temp_2[];
        Node temp;
            
        Arrays.sort(book_time, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        for(String time[] : book_time){
            temp_1 = time[0].split(":");
            temp_2 = time[1].split(":");
            temp = new Node(Integer.parseInt(temp_1[0])*60 + Integer.parseInt(temp_1[1]), Integer.parseInt(temp_2[0])*60 + Integer.parseInt(temp_2[1]) + 10);
            
            while(!pq.isEmpty() && pq.peek().end<=temp.start){
                pq.poll();
            }
            pq.offer(temp);
            answer = Math.max(answer, pq.size());
        }
        
        
        return answer;
    }
    static class Node{
        int start, end;
        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}