//01:40
import java.util.*;
class Solution {
    static int N;
    static Node input[];
    static String answer[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o2.start-o1.start);
    public String[] solution(String[][] plans) {
        N = plans.length;
        answer = new String[N];
        input = new Node[N+1];
        
        int idx = 0;
        for(String p[] : plans) input[idx++] = new Node(p[0], change(p[1]), Integer.parseInt(p[2]));
        input[N] = new Node("no", 60*24+100000, 0);
        
        Arrays.sort(input, (o1, o2) -> o1.start - o2.start);
        
        idx = 0;
        int time;
        Node temp;
        for(int i=0;i<N;i++){
            time = input[i].start+input[i].left;
            
            if(time<=input[i+1].start){
                answer[idx++] = input[i].name; 
                while(!pq.isEmpty()){
                    temp = pq.poll();
                    // System.out.println(temp);
                    if(time+temp.left<=input[i+1].start) {
                        answer[idx++] = temp.name;
                        time += temp.left;
                    }else{
                        temp.left -= input[i+1].start-time;
                        pq.offer(temp);
                        break;
                    }
                }
            }else{
                input[i].left -= input[i+1].start-input[i].start;
                pq.offer(input[i]);
            }
        }
        
        return answer;
    }
    static int change(String s){
        String temp[] = s.split(":");
        return Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
    }
    static class Node{
        String name;
        int start, left;
        
        public String toString() {
            return this.name+" "+this.start+" "+this.left;
        }
        
        Node(String name, int start, int left){
            this.name = name;
            this.start = start;
            this.left = left;
        }
    }
}