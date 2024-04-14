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
        visit = new int[K+1][N][M];

        for(int i = 0; i < N; i++){
            char c[] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = c[j]-'0';
            }
            for(int j = 0; j <= K; j++){
                Arrays.fill(visit[j][i], Integer.MAX_VALUE);
            }
        }

        bfs();

        answer = visit[0][N-1][M-1];
        for(int j = 1; j <= K; j++){
            answer = Math.min(answer, visit[j][N-1][M-1]);
        }
        if(answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }
    static void bfs() {
        pq.offer(new Node(1,0,0,K));
        visit[0][0][0] = 1;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(temp.y==N-1 && temp.x==M-1) continue;
            if(temp.h != 0){
                if(visit[temp.h-1][temp.y][temp.x] < temp.c &&  visit[temp.h][temp.y][temp.x] < temp.c) continue;
            }else if (visit[temp.h][temp.y][temp.x] < temp.c) continue;

            for(int i = 0; i < 4; i++){
                int ny = temp.y+dy[i];
                int nx = temp.x+dx[i];
                if(ny<0 || ny>=N || nx<0 || nx>=M) continue;

                if(map[ny][nx]==0 && visit[temp.h][ny][nx] > temp.c+1) {
                    pq.offer(new Node(temp.c+1,ny,nx,temp.h));
                    visit[temp.h][ny][nx] = temp.c+1;
                }
                else if (map[ny][nx]==1 && temp.h>0 && visit[temp.h-1][ny][nx] > temp.c+1) {
                    pq.offer(new Node(temp.c+1,ny,nx,temp.h-1));
                    visit[temp.h-1][ny][nx] = temp.c+1;
                }
            }
        }
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