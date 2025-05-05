//10:10
import java.util.*;
class Solution {
    static int N;
    static StringBuilder sb;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.head.compareTo(o2.head) == 0 ? o1.number==o2.number ? o1.idx-o2.idx : o1.number-o2.number : o1.head.compareTo(o2.head));
    public String[] solution(String[] files) {
        N = files.length;

        Node input;
        for(int i=0;i<N;i++){
            int idx_1 = 0, idx_2;
            
            sb = new StringBuilder(files[i]);
            input = new Node(files[i], i);
            
            for(;idx_1<sb.length();idx_1++){
                if(sb.charAt(idx_1)>='0' && '9'>=sb.charAt(idx_1)) break;
            }
            input.head = sb.substring(0, idx_1).toString().toUpperCase();
            idx_2 = idx_1;
            
            for(;idx_2<sb.length();idx_2++){
                if(sb.charAt(idx_2)<'0' || '9'<sb.charAt(idx_2)) break;
            }
            input.number = Integer.parseInt(sb.substring(idx_1, idx_2).toString());
            
            pq.offer(input);
        }
        
        
        String[] answer = new String[N];
        for(int i=0;i<N;i++){
            answer[i] = pq.poll().real;
        }
        return answer;
    }
    static class Node{
        String real, head;
        int number, idx;
        Node(String real, String head, int number, int idx){
            this.real = real;
            this.head = head;
            this.number = number;
            this.idx = idx;
        }
        Node(String real, int idx){
            this.real = real;
            this.idx = idx;
        }
    }
}