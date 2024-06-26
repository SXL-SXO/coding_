import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, answer = 0;
    static int map[][];
    static boolean visit[][];
    static int dy[] = {1,0,-1,0};
    static int dx[] = {0,1,0,-1};
    static Queue<Node> queue = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check();
        System.out.println(answer);
    }
    static void check(){
        int count = -1;
        boolean changemap = false;
        while(true){
            count=0;
            changemap = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    //System.out.println(count+" 0");
                    if(visit[i][j]) continue;
                    
                    visit[i][j] = true;
                    queue.offer(new Node(i, j));
                    count = 0;
                    //System.out.println(count+" 1");
                    count += near(i,j);
                    //System.out.println(count+" 2");
                    change(count);
                    //System.out.println(count+" 3");
                    if(count != map[i][j]) changemap = true;

                }   
            }
            // for(int a=0;a<N;a++){
            //     for(int b=0;b<N;b++){
            //         System.out.print(map[a][b]+" ");
            //     }
            //     System.out.println("");
            // }
            // System.out.println("-----");
            if(!changemap) break;

            for(int i=0;i<N;i++){
                Arrays.fill(visit[i], false);
            }

            answer++;
        }

    }
    static int near(int i, int j){
        int count = map[i][j];
        for(int a=0;a<4;a++){
            int ny = dy[a]+i;
            int nx = dx[a]+j;
            if(ny>=N||ny<0||nx>=N||nx<0||visit[ny][nx]||
            Math.abs(map[i][j]-map[ny][nx])<L||R<Math.abs(map[i][j]-map[ny][nx])) continue;
            visit[ny][nx] = true;
            queue.offer(new Node(ny,nx));
            count+=near(ny, nx);
        }
        return count;
    }
    static void change(int count){
        int size = queue.size();
        int people = count/size;
        //System.out.println("c:"+count+" s:"+size);
        for(int i=0;i<size;i++){
            Node temp = queue.poll();
            //System.out.print(temp);
            map[temp.y][temp.x] = people;
        }
    }
    static class Node{
        int y,x;
        Node(int y, int x){
            this.y=y;
            this.x=x;
        }
        @Override
        public String toString() {
            return "Node [y=" + y + ", x=" + x + "]";
        }
        
    }
}
