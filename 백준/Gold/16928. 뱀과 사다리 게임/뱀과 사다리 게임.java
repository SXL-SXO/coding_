import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int N, M, answer;
    static int map[] = new int[101]; //일반적으로 도착. 사다리타고도착. 뱀타고도착
    static int link[] = new int[101];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.c == o2.c ? o2.w - o1.w : o1.c - o2.c);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arrays.fill(map, -1);

        int a,b;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            link[a] = b;
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            link[a] = b;
        }

        bfs();
        System.out.println(answer);
    }
    static void bfs(){

        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            int nw;
            for(int i=6;i>0;i--){
                nw = temp.w+i;
                if(nw>100) continue;
                else if(nw==100) {
                    answer = temp.c+1;
                    return;
                }

                if(map[nw]==-1 || map[nw]!=-1 && map[nw]>temp.c+1){
                    map[nw] = temp.c+1;
                    if(link[nw]!=0) pq.offer(new Node(link[nw], temp.c+1));
                    else pq.offer(new Node(nw, +temp.c+1));
                }
            }
        }
    }
    static class Node{
        int w, c;
        Node(int w, int c){
            this.w = w;
            this.c = c;
        }
    }
}