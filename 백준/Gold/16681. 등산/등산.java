import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D, E;
    static Long answer = Long.MIN_VALUE;
    static int input[];
    static Long cost_up[], cost_down[];
    static boolean visit[];
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((o1, o2) -> o1.c<o2.c ? -1 : 1);
    static List<List<Node>> link = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        input = new int[N + 1];
        cost_up = new Long[N + 1];
        cost_down = new Long[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            link.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Long C = Long.parseLong(st.nextToken());
            if (input[A] < input[B])
                link.get(A).add(new Node(B, C));
            else if (input[A] > input[B])
                link.get(B).add(new Node(A, C));
        }

        dijkstra(1, cost_up);
        dijkstra(N, cost_down);

        for (int i = 2; i <= N - 1; i++) {
            if (cost_up[i] == Long.MAX_VALUE || cost_down[i] == Long.MAX_VALUE)
                continue;
            answer = Math.max(answer, -(cost_up[i] + cost_down[i]) * D + input[i] * E);
        }

        if (answer == Long.MIN_VALUE) {
            System.out.println("Impossible");
        } else {
            System.out.println(answer);
        }
    }

    static void dijkstra(int idx, Long[] cost) {
        Arrays.fill(visit, false);
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[idx] = 0L;
        pqueue.offer(new Node(idx, 0L));

        while (!pqueue.isEmpty()) {
            Node temp = pqueue.poll();
            if (visit[temp.v])
                continue;
            visit[temp.v] = true;
            for (Node n : link.get(temp.v)) {
                if (n.c + cost[temp.v] < cost[n.v]) {
                    cost[n.v] = n.c + cost[temp.v];
                    pqueue.offer(new Node(n.v, cost[n.v]));
                }
            }
        }

    }

    static class Node {
        int v;
        Long c;

        Node(int v, Long c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node [v=" + v + ", c=" + c + "]";
        }

    }
}
