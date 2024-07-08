import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int N, M, answer = 0;
    static boolean visit_fox[], visit_wolf[][];
    static int cost_fox[], cost_wolf[];

    static List<List<Node>> link = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->(o1.v-o2.v));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit_fox = new boolean[N+1];
        visit_wolf = new boolean[N+1][2];
        cost_fox = new int[N+1];
        cost_wolf = new int[N+1];
        for(int i = 0; i <= N; i++){
            link.add(new ArrayList<>());
        }
        int a, b, c;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            link.get(a).add(new Node(b, c*2));
            link.get(b).add(new Node(a, c*2));
        }

        dijstra();

        for(int i=1;i<=N;i++){
            if(cost_wolf[i]>cost_fox[i]) answer++;
        }

        System.out.println(answer);
//        System.out.println(Arrays.toString(cost_fox));
//        System.out.println(Arrays.toString(cost_wolf));
    }
    static void dijstra(){
        Node temp;

        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(visit_fox[temp.i]) continue;
            visit_fox[temp.i] = true;
            cost_fox[temp.i] = temp.v;
            for(Node n : link.get(temp.i)){
                if(visit_fox[n.i]) continue;
                pq.offer(new Node(n.i, n.v+temp.v));
            }
        }

        pq.offer(new Node(1, 0, 0));
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(visit_wolf[temp.i][temp.time%2]) continue;
            visit_wolf[temp.i][temp.time%2] = true;

            if(visit_wolf[temp.i][(temp.time+1)%2]) {
                if(temp.v < cost_wolf[temp.i]) cost_wolf[temp.i] = temp.v;
            }
            else cost_wolf[temp.i] = temp.v;


            for(Node n : link.get(temp.i)){
                if(visit_wolf[n.i][(temp.time+1)%2]) continue;
                if(temp.time%2==0) pq.offer(new Node(n.i, n.v/2+temp.v, 1));
                else pq.offer(new Node(n.i, n.v*2+temp.v, 0));
            }
        }
    }
    static class Node{
        int i, v, time;
        Node(int i, int v){
            this.i = i;
            this.v = v;
        }
        Node(int i, int v, int time){
            this.i = i;
            this.v = v;
            this.time = time;
        }
    }
}