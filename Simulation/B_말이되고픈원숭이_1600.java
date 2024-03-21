import java.io.*;
import java.util.*;

public class B_말이되고픈원숭이_1600 {
    static int K, W, H, answer = Integer.MAX_VALUE;
    static int map[][];
    static boolean visit[][][];
    static Monkey monkey;
    static Queue<Monkey> queue = new ArrayDeque<>();

    static int dy[] = { -1, 0, 1, 0 };
    static int kdy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int dx[] = { 0, 1, 0, -1 };
    static int kdx[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visit = new boolean[K + 1][H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (answer == Integer.MAX_VALUE)
            answer = -1;

        bfs();

        System.out.println(answer);
    }

    static class Monkey {
        int y, x, p;

        Monkey(int y, int x, int p) {
            this.y = y;
            this.x = x;
            this.p = p;
        }
    }

    static void bfs() {
        Monkey mon;
        int ny, nx, size, move = 0;
        queue.offer(new Monkey(0, 0, K));

        while (!queue.isEmpty()) {
            size = queue.size();
            for (int j = 0; j < size; j++) {
                mon = queue.poll();
                if (mon.y == H-1 && mon.x == W - 1) {
                    answer = move;
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    ny = mon.y + dy[i];
                    nx = mon.x + dx[i];

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] == 1 || visit[mon.p][ny][nx])
                        continue;
                    visit[mon.p][ny][nx] = true;
                    queue.offer(new Monkey(ny, nx, mon.p));
                }
                if (mon.p == 0)
                    continue;
                mon.p -= 1;
                for (int i = 0; i < 8; i++) {
                    ny = mon.y + kdy[i];
                    nx = mon.x + kdx[i];

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || map[ny][nx] == 1 || visit[mon.p][ny][nx])
                        continue;
                    visit[mon.p][ny][nx] = true;
                    queue.offer(new Monkey(ny, nx, mon.p));
                }
            }
            move++;
        }
    }
    // static void dfs(){
    // Node temp;
    // int ny, nx;
    // while(!pqueue.isEmpty()){
    // temp = pqueue.poll();
    // if(map[temp.y][temp.x]) continue;
    // map[temp.y][temp.x] = true;
    // if(temp.p>0){
    // for(int i=4;i<12;i++){
    // ny = temp.y+dy[i];
    // nx = temp.x+dx[i];

    // if( ny<0 || ny>=H || nx<0 || nx>=W ) continue;
    // if(cost[ny][nx] <= temp.m+1) continue;
    // cost[ny][nx] = temp.m+1;
    // pqueue.offer(new Node(ny, nx, temp.m+1, temp.p-1));
    // }
    // }
    // for(int i=0;i<4;i++){
    // ny = temp.y+dy[i];
    // nx = temp.x+dx[i];

    // if( ny<0 || ny>=H || nx<0 || nx>=W ) continue;
    // if(cost[ny][nx]<=temp.m+1) continue;
    // cost[ny][nx] = temp.m+1;
    // pqueue.offer(new Node(ny, nx, temp.m+1, temp.p));
    // }

    // }
    // }
    // static void dfs(){
    // if(monkey.y==H-1 && monkey.x==W-1){
    // answer = Math.min(monkey.m, answer);
    // return;
    // }
    // int ny, nx;
    // if(monkey.m>answer) return;
    // for(int i=0;i<4;i++){
    // ny = monkey.y + dy[i];
    // nx = monkey.x + dx[i];

    // if( ny<0 || ny>=H || nx<0 || nx>=W ) continue;
    // if( map[ny][nx] ) continue;

    // map[ny][nx] = true;
    // monkey.y+=dy[i];
    // monkey.x+=dx[i];
    // monkey.m++;

    // dfs();

    // map[ny][nx] = false;
    // monkey.y-=dy[i];
    // monkey.x-=dx[i];
    // monkey.m--;
    // }
    // if(K==0) return;
    // K--;
    // for(int i=4;i<12;i++){
    // ny = monkey.y + dy[i];
    // nx = monkey.x + dx[i];

    // if( ny<0 || ny>=H || nx<0 || nx>=W ) continue;
    // if( map[ny][nx]) continue;

    // map[ny][nx] = true;
    // monkey.y+=dy[i];
    // monkey.x+=dx[i];
    // monkey.m++;

    // dfs();

    // map[ny][nx] = false;
    // monkey.y-=dy[i];
    // monkey.x-=dx[i];
    // monkey.m--;
    // }
    // K++;
    // }
}
