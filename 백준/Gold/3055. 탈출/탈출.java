import java.io.*;
import java.util.*;

public class Main {
    static int R,C, end;
    static boolean visit[][];
    static char map[][];
    static Queue<Integer> queue_w = new ArrayDeque<>();
    static Queue<Integer> queue_d = new ArrayDeque<>();
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        visit = new boolean[R][C];

        for(int i=0;i<R;i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0;j<C;j++){
                if(map[i][j]=='.') visit[i][j] = true; 
                else if(map[i][j] == 'D') {end = C*i+j; visit[i][j] = true;}
                else if(map[i][j] == 'S') queue_d.offer(C*i+j);
                else if(map[i][j] == '*') queue_w.offer(C*i+j);
            }
        }

        bfs();
    }
    static void bfs(){
        //물먼저, 그다음에 전진
        int time = 0;
        while (!queue_d.isEmpty()) {
            int size = queue_w.size();
            for(int i=0;i<size;i++){
                int temp = queue_w.poll();
                int y = temp/C, x = temp%C;
    
                for(int j=0;j<4;j++){
                    int ny = y+dy[j], nx = x+dx[j];
                    if(ny>=R||ny<0||nx>=C||nx<0||!visit[ny][nx]||ny*C+nx==end) continue;
                    visit[ny][nx] = false;
                    queue_w.offer(ny*C+nx);
                }
            }
            size = queue_d.size();
            for(int i=0;i<size;i++){
                int temp = queue_d.poll();
                if(temp == end) {
                    System.out.println(time);
                    return;
                }
                int y = temp/C, x = temp%C;
                for(int j=0;j<4;j++){
                    int ny = y+dy[j], nx = x+dx[j];
                    if(ny>=R||ny<0||nx>=C||nx<0||!visit[ny][nx]) continue;
                    visit[ny][nx] = false;
                    queue_d.offer(ny*C+nx);
                }
            }
            time++;
        }
        System.out.println("KAKTUS");

    }
}
