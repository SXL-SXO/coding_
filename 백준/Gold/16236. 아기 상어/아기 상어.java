import java.io.*;
import java.util.*;

public class Main {
    static int N, shark, size = 2, answer = 0, count = 0;
    static boolean posible = true;
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)-> o1.move==o2.move ? o1.where-o2.where : o1.move-o2.move);
    static int map[][];
    static boolean visit[][];
    static int dy[] = {-1,0,0,1};
    static int dx[] = {0,-1,1,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) continue;
                else if(map[i][j]==9) shark = i*100+j;
            }
        }
        map[shark/100][shark%100] = 0;
        while(true){
            go();
            if(!posible) break;
            //System.out.println(answer+" "+move);
        }
        System.out.println(answer);
    }
    static void go(){
        visit = new boolean[N][N];
        queue.offer(new Node(0, shark));
        visit[shark/100][shark%100] = true;
        // System.out.println(shark/100 +" "+shark%100+" "+size);
        // for(int i=0;i<N;i++){
        //     for(int j=0;j<N;j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println("");
        // }
        while(!queue.isEmpty()){
            int qsize = queue.size();
            
            for(int j=0;j<qsize;j++){
                Node temp = queue.poll();
                int temp_w = temp.where;
                int temp_m = temp.move;
                if(map[temp_w/100][temp_w%100]!=0&&map[temp_w/100][temp_w%100]<size){
                    count++;
                    if(count==size) {
                        count=0;
                        size++;
                    }
                    queue.clear();
                    map[temp_w/100][temp_w%100] = 0;
                    shark = temp_w;
                    answer+=temp_m;
                    return;
                }

                for(int i=0;i<4;i++){
                    int ny = temp_w/100 +dy[i];
                    int nx = temp_w%100 +dx[i];

                    if(ny<0||ny>=N||nx<0||nx>=N||visit[ny][nx]||map[ny][nx]>size) continue;
                    
                    visit[ny][nx] = true;
                    queue.offer(new Node(temp_m+1,ny*100+nx));
                }
            }
        }
        posible = false;        
    }
    static class Node{
        int move, where;
        Node(int move, int where){
            this.move = move;
            this.where = where;
        }
    }
}
