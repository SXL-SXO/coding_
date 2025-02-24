import java.util.*;
class Solution {
    static String temp1[], temp2[];
    static Node[] time;
    static int answer = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.eh==o2.eh ? o1.em==o2.em ? o1.sh==o2.sh ? o1.sm-o2.sm : o1.sh-o2.sh : o1.em-o2.em : o1.eh-o2.eh);
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0])==0 ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        
        time = new Node[book_time.length];
        for(int i=0;i<book_time.length;i++) {
            temp1 = book_time[i][0].split(":");
            temp2 = book_time[i][1].split(":");
            time[i] = new Node(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]), Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]));
        }
        
        Node n;
        pq.offer(time[0]);
        for(int i=1;i<time.length;i++){
            answer = Math.max(answer, pq.size());
            
            while(!pq.isEmpty()) {
                n = pq.poll();
                if(!check(n.eh, n.em, time[i].sh, time[i].sm )) {
                    pq.offer(n);
                    break;
                }
            }
            pq.offer(time[i]);
        }
        answer = Math.max(answer, pq.size());
                             
        return answer;
    }
    static boolean check(int h1, int m1, int h2, int m2){
        if(h1+1<h2) return true;
        else if(h1<h2 && m1+10 <= 60+m2) return true;
        else if(h1==h2 && m1+10 <= m2) return true;
        else return false;
    }
    static class Node{
        int sh, sm, eh, em;
        Node(int sh, int sm, int eh, int em){
            this.sh=sh;
            this.sm=sm;
            this.eh=eh;
            this.em=em;
        }
    }
}