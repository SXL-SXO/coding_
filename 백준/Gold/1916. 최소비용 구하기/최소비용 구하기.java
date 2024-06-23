import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int N, M, start, end;
    static int cost[];
    static boolean visit[];

    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.c-o2.c);
    static List<List<Node>> link = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++){
            link.add(new ArrayList<>());
        }
        cost = new int[N+1];
        visit = new boolean[N+1];
        Arrays.fill(cost, -1);

        int a, b, c;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            link.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijistra();
        System.out.println(cost[end]);
    }
    static void dijistra(){
        pq.offer(new Node(start, 0));
        Node temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(visit[temp.i]) continue;
            cost[temp.i] = temp.c;
            visit[temp.i] = true;
            for(Node n : link.get(temp.i)){
                if(!visit[n.i] || temp.c+n.c < cost[n.i]){
                    pq.offer(new Node(n.i, n.c+temp.c));
                }
            }
        }

    }
    static class Node{
        int i, c;
        public Node(int i, int c){
            this.i = i;
            this.c = c;
        }
    }
}