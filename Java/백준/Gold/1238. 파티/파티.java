import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, X, answer = 0;
    static int go_dijistra[], back_dijistra[];
    static boolean visit[];
    static List<List<Node>> go = new ArrayList<>();
    static List<List<Node>> back = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.c-o2.c);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        
        go_dijistra = new int[N];
        back_dijistra = new int[N];
        
        Arrays.fill(go_dijistra, Integer.MAX_VALUE);
        Arrays.fill(back_dijistra, Integer.MAX_VALUE);
        
        
        for(int i=0;i<N;i++){
            go.add(new ArrayList<>());
            back.add(new ArrayList<>());
        }
        
        int a, b, c;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken());
            
            go.get(a).add(new Node(b,c));
            back.get(b).add(new Node(a,c));
        }
        
        pq.offer(new Node(X, 0));
        dijistra(go_dijistra, go);
        
        pq.offer(new Node(X, 0));
        dijistra(back_dijistra, back);
        
        for(int i=0;i<N;i++){
            answer = Math.max(answer, go_dijistra[i]+back_dijistra[i]);
        }
        
        System.out.print(answer);
    }
    static void dijistra(int cost[], List<List<Node>> link){
        visit = new boolean[N];
        
        Node temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(visit[temp.w]) continue;
            visit[temp.w] = true;
            cost[temp.w] = temp.c;
            
            for(Node n : link.get(temp.w)){
                if(visit[n.w] || temp.c+n.c>=cost[n.w]) continue;
                pq.offer(new Node(n.w, temp.c+n.c));
            }
        }
    }
    static class Node{
        int w, c;
        Node(int w, int c){
            this.w=w;
            this.c=c;
        }
    }
}