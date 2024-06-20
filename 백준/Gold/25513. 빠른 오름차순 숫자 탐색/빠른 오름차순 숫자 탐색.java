import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int goal = 1, count=0, now;
    static int map[][] = new int[5][5];
    static boolean visit[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        now = Integer.parseInt(st.nextToken())*5 + Integer.parseInt(st.nextToken());
        bfs();
        System.out.println(count);
    }
    static void bfs() {
        if(goal == 7 || count==-1){
            return;
        }
        queue.clear();
        queue.offer(now);
        visit = new boolean[5][5];
        visit[now/5][now%5] = true;
        int size, y, x, temp, ny, nx;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int j=0; j<size; j++){
                temp = queue.poll();
                y = temp/5;
                x = temp%5;
                if(map[y][x] == goal){
                    goal++;
                    now = temp;
                    bfs();
                    return;
                }
                for(int i=0; i<4; i++){
                    ny = y+dy[i];
                    nx = x+dx[i];
                    if(ny>=5||nx>=5||ny<0||nx<0||visit[ny][nx]||map[ny][nx]==-1) continue;
                    visit[ny][nx] = true;
                    queue.offer(ny*5+nx);
                }
            }

            count++;
        }
        count=-1;
    }
}