
import java.io.*;
import java.util.*;
public class B_치즈_2638 {
    static int[][] map;
    static int H, W, time;
    static Queue<Node> cheese = new ArrayDeque<>();
    static Queue<Node> air = new ArrayDeque<>();

    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        time = 0;
        map = new int[H][W];
        

        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) cheese.offer(new Node(i,j));
            }
        }
        
        checkair(new Node(0,0));
        while(!cheese.isEmpty()){
            int size = cheese.size();
            
            for(int k=0;k<size;k++){
                checkcheese(cheese.poll());
            }
            size = air.size();
            for(int k=0;k<size;k++){
                change(air.poll());
            }
            // for(int i=0;i<H;i++){
            //     for(int j=0;j<W;j++){
            //         System.out.printf("%2d",map[i][j]);
            //     }
            //     System.out.println("");
            // }
            time++;
        }
        
        System.out.println(time);

    }


    // 공기가 바깥과 연결되었는지 체크
    static void checkair(Node temp){
        int ny, nx, k=0;
        for(;k<4;k++){
            ny=temp.y+dy[k];
            nx=temp.x+dx[k];
            if(ny>=H||nx>=W||ny<0||nx<0) continue;
            if(map[ny][nx]!=0) continue;
            map[ny][nx]=-2;
            checkair(new Node(ny, nx));
        }
    }
    // 치즈가 공기와 닿았는지 체크
    static void checkcheese(Node temp){
        int ny, nx, count = 0;
        for(int k=0;k<4;k++){
            ny=temp.y+dy[k];
            nx=temp.x+dx[k];
            if(ny>=H||nx>=W||ny<0||nx<0) continue;
            if(map[ny][nx]==-2) count++;
        }
        if(count<2) cheese.offer(temp); 
        else air.offer(temp);
    }
    static void change(Node temp){
        map[temp.y][temp.x]=-2;
        checkair(temp);
    }
    static class Node{
        int y,x;
        Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
}
