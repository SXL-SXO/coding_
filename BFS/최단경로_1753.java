package ss_study;

import java.io.*;
import java.util.*;

public class 최단경로_1753 {
    static class Node implements Comparable<Node> {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight == o.weight )
                return this.num - o.num;
            else return this.weight - o.weight;
        }
    }
    static Map<Integer, PriorityQueue<Node>> map = new HashMap<Integer, PriorityQueue<Node>>() ;
    static int answer[];
    static int end;
    static void check_v (int start, int cost){
        if(map.get(start) == null) return;
        PriorityQueue<Node> link = new PriorityQueue<Node>(map.get(start));
        PriorityQueue<Node> link_ = new PriorityQueue<Node>();

        while(link.size()!=0){
            Node s = link.poll();
            link_.offer(s);
            if(s.num==end || s.num>=answer.length) continue; 
            if(answer[s.num] == 0 || (answer[s.num] > s.weight + cost)){
                answer[s.num] = s.weight + cost;
                check_v(s.num, answer[s.num]);
            }
        }
        map.put(start,link_);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V =Integer.parseInt(st.nextToken());
        int E =Integer.parseInt(st.nextToken());

        end = Integer.parseInt(br.readLine())-1;
        
        answer = new int[V];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            Node abc = new Node(b,c);
            PriorityQueue<Node> bc;

            if(map.containsKey(a)) bc = map.get(a); 
            else bc = new PriorityQueue<>();
            bc.add(abc);
            map.put(a,bc);
        }
        
        check_v(end, 0);

        for(int j=0;j<V;j++){
            if(j==end) sb.append("0\n");
            else if(answer[j]==0) sb.append("INF\n");
            else {sb.append(answer[j]).append("\n");}
        }

        System.out.print(sb.toString());
    }
    
}
