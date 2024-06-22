import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int N, M, R, C, answer = Integer.MAX_VALUE;
    static int map[][];
    static boolean visit[][];

    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) ->( o1.total==o2.total ? o1.cost-o2.cost : o1.total-o2.total));

    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visit = new boolean[N][M];

        int y, x, c;
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken())-1;
            x = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken());
            map[y][x] = c;
            pq.offer(new Node(y,x,c,0));
        }

        for(int i=0;i<C;i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = -1;
        }

        bfs();
        System.out.println(answer);
    }
    static void bfs(){
        int  ny, nx;
        Node temp;

        while(!pq.isEmpty()){
            temp = pq.poll();
//            System.out.println(temp);
            for(int i=0;i<4;i++){
                ny = temp.y + dy[i];
                nx = temp.x + dx[i];
                if(ny>=N || ny<0 || nx>=M || nx<0 || visit[ny][nx] || answer<=temp.total+temp.cost) continue;
                else if(map[ny][nx] == -1){
                    answer = Math.min(answer, temp.total+temp.cost);
                    continue;
                }
                if(temp.total!=0) visit[ny][nx] = true;
                pq.offer(new Node(ny,nx,temp.cost,temp.total+temp.cost));
            }
        }
    }
    static class Node{
        int y,x,cost,total;
        Node(int y,int x,int cost,int total){
            this.y = y;
            this.x = x;
            this.cost = cost;
            this.total = total;
        }

    }
}