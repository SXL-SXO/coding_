import java.io.*;
import java.util.*;

public class Main {
    static int N, M, A, B, answer = 0;
    static long cost[];
    static boolean visit[];
    static List<List<Node>> link = new ArrayList<>();
    static PriorityQueue<Node> pqueue = new PriorityQueue<>
    ((o1,o2)->o1.c == o2.c? 0 : o1.c < o2.c ? -1:1);
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        cost = new long[N+1];
        visit = new boolean[N+1];

        for(int i=0;i<=N;i++){
            cost[i] = 3000000000000000L;
            link.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            link.get(a).add(new Node(b, c));
            link.get(b).add(new Node(a, c));
        }

        dijkstra();

        check();
        sb.append(answer).append('\n');
        for(int i = 1; i <= N; i++) {
            if(visit[i]) sb.append(i + " ");
        }
        System.out.println(sb.toString());
    }
    static void check(){
        Arrays.fill(visit, false);
        ArrayDeque<Integer> queue = new ArrayDeque();
        queue.offer(B);
        answer++;
        visit[B] = true;
        
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(Node n : link.get(temp)){
                if(!visit[n.v] && (cost[n.v] + n.c == cost[temp])){
                    visit[n.v] = true;
                    queue.add(n.v);
                    answer++;
                }
            }
        }
    }

    static void dijkstra(){
        pqueue.offer(new Node(A, 0));
        cost[A] = 0;
        while(!pqueue.isEmpty()){
            Node temp = pqueue.poll();
            if(visit[temp.v]) continue;
            visit[temp.v] = true; 
            for(Node n : link.get(temp.v)){
                if(!visit[n.v] && (cost[n.v] > cost[temp.v]+n.c)){
                    cost[n.v]=cost[temp.v]+n.c;
                    pqueue.add(new Node(n.v, cost[n.v]));
                }
            }
        }
    }
    static class Node{
        int v;
        long c;
        Node(int v, long c){
            this.v=v;
            this.c=c;
        }
    }
}
