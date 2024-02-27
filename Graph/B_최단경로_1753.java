import java.io.*;
import java.util.*;

public class B_최단경로_1753 {
    static int V, E, S;
    static int visit[];
    static List<List<Node>> list = new ArrayList<>();
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.c-o2.c);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());


        visit = new int[E+1];
        Arrays.fill(visit, Integer.MAX_VALUE);
        visit[S] = 0;


        for(int i=0;i<=V;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list.get(A).add(new Node(B, C));        
        }     

        queue.offer(new Node(S, 0));

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for(Node e : list.get(temp.v)){
                if(visit[e.v] > e.c+visit[temp.v]){
                    visit[e.v] = e.c+visit[temp.v];
                    queue.offer(e);
                }
            }
        }
        for(int i=1;i<=V;i++){
            if(visit[i]==Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(visit[i]);
        }
    }
    
    static class Node{
        int v,c;
        Node(int v, int c){
            this.v=v;
            this.c=c;
        }
    }
}
