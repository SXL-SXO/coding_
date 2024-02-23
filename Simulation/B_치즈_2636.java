package 완료;
import java.io.*;
import java.util.*;
public class B_치즈_2636 {
    static int[][] map;
    static int H, W, cheese, time;
    static Queue<Node> air = new ArrayDeque<>();

    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        time = 0;
        cheese = 0;
        map = new int[H][W];
        

        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<W;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) cheese+=1;
            }
        }
        air.offer(new Node(0,0));
        int CheeseToAir = 0;    
        while(cheese!=0){
            checkair(air.poll());
            removecheese();
            CheeseToAir = changeMap();
            cheese-=CheeseToAir;
            time++;
        }
        
        System.out.println(time+"\n"+CheeseToAir);

    }

    // 공기가 바깥과 닿았는지 체크
    static void checkair(Node temp){
        air.offer(temp);
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
    //한바퀴돌면서 air랑 닿은 녀석들 쳌
    static void removecheese(){
        int size = air.size();
        int ny, nx;
        Node temp;
        for(int i=0;i<size;i++){
            temp = air.poll();
            for(int k=0;k<4;k++){
                ny=temp.y+dy[k];
                nx=temp.x+dx[k];
                if(ny>=H||nx>=W||ny<0||nx<0) continue;
                else if(map[ny][nx]==1) {
                    map[ny][nx]=-1;
                    air.offer(new Node(ny, nx));
                    checkair(new Node(ny, nx));
                }
            }        
        }
    }
    //시간이 끝나면서 주변 바뀌기
    static int changeMap(){
        int size = air.size(), count=0;
        Node temp;
        for(int i=0;i<size;i++){
            temp = air.poll();
            if(map[temp.y][temp.x]==-1) count++;
            map[temp.y][temp.x]=-2;
            air.offer(temp);
        }
        return count;
    }
    static class Node{
        int y,x;
        Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
}
