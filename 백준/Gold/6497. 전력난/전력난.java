import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int M,N;
    static List<List<Node>> list;
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.c-o2.c);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if(M == 0 && N == 0) break;

            list = new ArrayList<>();
            visit = new boolean[M];
            for(int i = 0; i < M; i++){
                list.add(new ArrayList<>());
            }

            int a, b, c, total = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                total += c;
                list.get(a).add(new Node(b,c));
                list.get(b).add(new Node(a,c));
            }

            Mst(total);
        }
        System.out.println(sb);
    }
    static void Mst(int total){
        int cost = 0, count = 0;
        pq.clear();
        pq.offer(new Node(1,0));
        while(!pq.isEmpty()||count == N){
            Node temp = pq.poll();
            if(visit[temp.i]) continue;
            count++;
            cost += temp.c;
            visit[temp.i] = true;
            for(Node node : list.get(temp.i)){
                if(!visit[node.i]) pq.offer(node);
            }
        }
        sb.append(total-cost).append("\n");
    }
    static class Node{
        int i,c;
        Node(int i,int c){
            this.i = i;
            this.c = c;
        }
    }
}