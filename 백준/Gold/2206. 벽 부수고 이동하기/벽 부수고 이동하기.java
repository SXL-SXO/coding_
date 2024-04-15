import java.io.*;
import java.util.*;
public class Main {
    static int N, M, answer;
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
        q.offer(new Node(0,0,1));
        visit[1][0][0] = 1;
        while(!q.isEmpty()){
            Node temp = q.poll();
            int y = temp.y, x = temp.x, h = temp.h, c = visit[h][y][x];
            if(temp.y==N-1 && temp.x==M-1) return;
            if((visit[0][temp.y][temp.x]<c && visit[1][temp.y][temp.x]<c)) continue;
            for(int i = 0; i < 4; i++){
                int ny = y+dy[i];
                int nx = x+dx[i];
                if(ny<0 || ny>=N || nx<0 || nx>=M) continue;

                if(map[ny][nx]==0 && visit[h][ny][nx] > c+1) {
                    q.offer(new Node(ny,nx,h));
                    visit[h][ny][nx] = c+1;
                }
                else if (map[ny][nx]==1 && temp.h==1 && visit[h][ny][nx] > c+1) {
                    q.offer(new Node(ny,nx,h-1));
                    visit[h-1][ny][nx] = c+1;
                }
            }
        }
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