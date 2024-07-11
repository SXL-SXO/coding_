import java.util.*;
class Solution {
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.hp==o2.hp ? o1.idx-o2.idx : o2.hp-o1.hp);
    static boolean visit[];
    public int solution(int[] picks, String[] minerals) {
        int answer = 0, total = 0, d = 0, i = 0, s = 0;
        
        total += picks[0];
        total += picks[1];
        total += picks[2];
        
        visit = new boolean[(minerals.length+4)/5];
        
        for(int a=0;a<total*5;a++){
            if(minerals[a].equals("diamond")) d++;
            else if(minerals[a].equals("iron")) i++;
            else s++;
            
            if((a+1)%5==0) {
                pq.offer(new Node(d*25+i*5+s, a/5, d, i, s));
                pq.offer(new Node(d*5+i+s, a/5, d, i, s));
                pq.offer(new Node(d+i+s, a/5, d, i, s));
                d = 0;
                i = 0;
                s = 0;
                if(a==total*5-1 || a==minerals.length-1) break;
            } else if(a==minerals.length-1){
                pq.offer(new Node(d*25+i*5+s, a/5, d, i, s));
                pq.offer(new Node(d*5+i+s, a/5, d, i, s));
                pq.offer(new Node(d+i+s, a/5, d, i, s));
                break;
            }
        }
        
        
        Node temp;
        int a = 0;
        while(!pq.isEmpty() && a<3){            
            if(picks[a]==0) {
                a++;
                continue;
            }
            temp = pq.poll();
            
            if(visit[temp.idx]) continue;
            visit[temp.idx] = true;
            
            if(a==0){
                answer+=temp.d;
                answer+=temp.i;
                answer+=temp.s;
            }else if(a==1){
                answer+=temp.d*5;
                answer+=temp.i;
                answer+=temp.s;
            }else{
                answer+=temp.d*25;
                answer+=temp.i*5;
                answer+=temp.s;
            }
            
            picks[a]--;
        }
        
        return answer;
    }
    static class Node{
        int hp, idx, d, i, s;
        Node(int hp, int idx, int d, int i, int s){
            this.hp=hp;
            this.idx=idx;
            this.d=d;
            this.i=i;
            this.s=s;
        }
    }
}