import java.io.*;
import java.util.*;

public class Main {
    static int R,C,T,answer = 2;
    static int map[][];
    static int airclear[] = new int[2];
    static Queue<Node> queue = new ArrayDeque<>();

    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int k=0;
        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0) queue.offer(new Node(i, j, map[i][j]));
            }
            if(map[i][0] == -1)  airclear[k++] = i;
        }
        
        for(int i=0;i<T;i++){
            //확산
            check();
            //적용
            commit(i);
            //이동
            move();
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
    static void check(){
        int size = queue.size();
        for(int i=0;i<size;i++){
            Node temp = queue.poll();
            int meonji = temp.c;
            for(int j=0;j<4;j++){
                int ny = temp.y+dy[j];
                int nx = temp.x+dx[j];
                if(ny>=R || ny<0 || nx>=C || nx<0 || (nx==0 && (ny==airclear[0]||ny==airclear[1]))) continue;
                queue.offer(new Node(ny, nx, temp.c/5));
                meonji-=temp.c/5;
            }
            queue.offer(new Node(temp.y, temp.x, meonji));
        }
    }
    static void commit(int time){
        for(int i=0;i<R;i++){
            Arrays.fill(map[i],0);
        }
        map[airclear[0]][0] = -1;
        map[airclear[1]][0] = -1;

        int size = queue.size();
        for(int i=0;i<size;i++){
            Node temp = queue.poll();
            map[temp.y][temp.x]+=temp.c;
        }
    }
    static void move(){
        int y,x,ny,nx;

        // 공기청정기 위쪽기준
        y = airclear[0]-1 ; x = 0;
        for(int i=0;i<4;){
            ny = y+dy[i]; nx = x+dx[i];
            if(ny>=airclear[1] || ny<0 || nx>=C || nx<0 || (ny == airclear[0] && nx == 0)) {
                i++;
                continue;
            }
            map[y][x] = map[ny][nx];
            y = ny; x = nx;
        }
        map[airclear[0]][1] = 0;

        //공기청정기 아래쪽기준
        y = airclear[1]+1 ; x = 0;
        for(int i=2;;){
            ny = y+dy[i]; nx = x+dx[i];
            if(ny>=R|| ny<=airclear[0] || nx>=C || nx<0 || (ny == airclear[1] && nx == 0)) {
                i--;
                if(i==-1) i=3;
                if(i==2) break;
                continue;
            }
            map[y][x] = map[ny][nx];
            y = ny; x = nx;
        }
        map[airclear[1]][1] = 0;

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j]>0) queue.offer(new Node(i, j, map[i][j]));
            }
        }
    }

    static class Node{
        int y, x, c;
        Node(int y,int x,int c){
            this.y=y;
            this.x=x;
            this.c=c;
        }
    }
}
