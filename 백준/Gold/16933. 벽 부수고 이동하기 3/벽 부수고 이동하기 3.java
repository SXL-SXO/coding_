import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int N, M, K, answer;
    static int[][] map;
    static int[][][] visit;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.c-o2.c);

    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        visit = new int[N][M][K+1];

        for(int i = 0; i < N; i++){
            char c[] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = c[j]-'0';
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        answer = bfs();
        
        System.out.println(answer);
    }
    static int bfs() {
        pq.offer(new Node(1,0,0,0));
        visit[0][0][0] = 1;

        int y,x,h,c;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            y = temp.y;
            x = temp.x;
            h = temp.h;
            c = temp.c;
            if(y==N-1 && x==M-1) return c;
            for(int i = 0; i < 4; i++){
                int ny = temp.y+dy[i];
                int nx = temp.x+dx[i];
                if(ny<0 || ny>=N || nx<0 || nx>=M) continue;

                if(map[ny][nx]==0 && visit[ny][nx][h] > c+1) {
                    pq.offer(new Node(c+1,ny,nx,h));
                    visit[ny][nx][h] = c+1;
                }
                else if (map[ny][nx]==1 && h<K) {
                    if(c%2==1 && visit[ny][nx][h+1] > c+1){
                        pq.offer(new Node(c+1,ny,nx,h+1));
                        visit[ny][nx][h+1] = c+1;
                    }else if(c%2==0 && visit[ny][nx][h+1] > c+2){
                        pq.offer(new Node(c+2,ny,nx,h+1));
                        visit[ny][nx][h+1] = c+2;
                    }
                }
            }
        }
        return -1;
    }
    static class Node{
        int c, y, x, h;
        Node(int c, int y, int x, int h){
            this.c = c;
            this.y = y;
            this.x = x;
            this.h = h;
        }
    }
}