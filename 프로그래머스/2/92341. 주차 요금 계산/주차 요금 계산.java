// 04:54
import java.util.*;

class Solution {
    static int answer[];
    static int N = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.n-o2.n);
    public int[] solution(int[] fee, String[] records) {
        
        String temp[];
        int num, t;
        for(String s : records){
            temp = s.split(" ");
            t = change(temp[0].split(":"));
            num = Integer.parseInt(temp[1]);
            if(temp[2].equals("IN")) {
                if(!map.containsKey(num)) N++;
                map.put(num, t);
            }else{
                t -= map.get(num);
                
                map.put(num, -1);    
                pq.offer(new Node(num, t));
            }
        }
         
        for(int m : map.keySet()){
            if(map.get(m)==-1) continue;
            t = 24*60 - 1 - map.get(m);
            pq.offer(new Node(m, t));
        }
                         
        answer = new int[N];
        
        Node a = pq.poll(), b;
        int i = 0, total = a.t;
        
        while(!pq.isEmpty()){
            b = a;
            a = pq.poll();
            if(a.n == b.n) total += a.t;
            else {
                answer[i++] += total <= fee[0] ? fee[1] : fee[1] + (total-fee[0]+fee[2]-1)/fee[2]*fee[3];
                System.out.println(a.n+" "+a.t+" "+total);
                total = a.t;
            }
        }
        System.out.println(a.n+" "+a.t+" "+total);
        answer[i] = total <= fee[0] ? fee[1] : fee[1] + (total-fee[0]+fee[2]-1)/fee[2]*fee[3];
        
        return answer;
    }
    static class Node{
        int n, t;
        Node(int n, int t){
            this.n=n;
            this.t=t;
        }
    }
    static int change(String t[]) {
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}