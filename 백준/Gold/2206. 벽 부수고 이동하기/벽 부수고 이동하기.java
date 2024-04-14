import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int N, M, answer;
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

        map = new int[N][M];
        visit = new int[2][N][M];

        for(int i = 0; i < N; i++){
            char c[] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = c[j]-'0';
            }
            Arrays.fill(visit[0][i], Integer.MAX_VALUE);
            Arrays.fill(visit[1][i], Integer.MAX_VALUE);
        }

        bfs();

        answer = Math.min(visit[0][N-1][M-1],visit[1][N-1][M-1]);
        if(answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }
    static void bfs() {
        pq.offer(new Node(1,0,0,1));
        visit[0][0][0] = 1;
        visit[1][0][0] = 1;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if((visit[0][temp.y][temp.x]<temp.c && visit[1][temp.y][temp.x]<temp.c) || (temp.y==N-1 && temp.x==M-1)) continue;
            for(int i = 0; i < 4; i++){
                int ny = temp.y+dy[i];
                int nx = temp.x+dx[i];
                if(ny<0 || ny>=N || nx<0 || nx>=M) continue;

                if(map[ny][nx]==0 && temp.h==0 && visit[0][ny][nx] > temp.c+1) {
                    pq.offer(new Node(temp.c+1,ny,nx,temp.h));
                    visit[0][ny][nx] = temp.c+1;
                }
                else if(map[ny][nx]==0 && temp.h==1 && visit[1][ny][nx] > temp.c+1) {
                    pq.offer(new Node(temp.c+1,ny,nx,temp.h));
                    visit[1][ny][nx] = temp.c+1;
                }
                else if (map[ny][nx]==1 && temp.h==1 && visit[1][ny][nx] > temp.c+1) {
                    pq.offer(new Node(temp.c+1,ny,nx,temp.h-1));
                    visit[1][ny][nx] = temp.c+1;
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