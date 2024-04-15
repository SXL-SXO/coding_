import java.io.*;
import java.util.*;
public class Main {
    static int N, M, K, answer;
    static int[][] map;
    static int[][][] visit;
    static Queue<Node> q = new ArrayDeque<>();

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
        int y,x,h,c;
        q.offer(new Node(0,0,0));
        visit[0][0][0] = 1;
        while(!q.isEmpty()){
            Node temp = q.poll();
            y = temp.y;
            x = temp.x;
            h = temp.h;
            c = visit[y][x][h];
            if( y==N-1 && x==M-1) return c;

            for(int i = 0; i < 4; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny<0 || ny>=N || nx<0 || nx>=M) continue;

                if(map[ny][nx]==0 && visit[ny][nx][h] > c+1) {
                    q.offer(new Node(ny,nx,h));
                    visit[ny][nx][h] = c+1;
                }
                else if (map[ny][nx]==1 && h+1<=K && visit[ny][nx][h+1] > c+1) {
                    q.offer(new Node(ny,nx,h+1));
                    visit[ny][nx][h+1] = c+1;
                }
            }
        }
        return -1;
    }
    static class Node{
        int y, x, h;
        Node(int y, int x, int h){
            this.y = y;
            this.x = x;
            this.h = h;
        }
    }
}