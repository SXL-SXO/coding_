import java.io.*;
import java.util.*;

public class B_토마토_7569 {
    static int M,N,H,answer=0,count_non=0;
    static int box[][][];
    static Queue<Node> queue =new ArrayDeque<>();
    static int dz[] = {0,0,0,0,1,-1};
    static int dy[] = {1,-1,0,0,0,0};
    static int dx[] = {0,0,1,-1,0,0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        for(int i=0;i<H;i++){
            for(int j=0;j<N;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<M;k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k]==1) queue.offer(new Node(i, j, k)); 
                    else if(box[i][j][k]==0) count_non++; 
                }
            }
        }
        if(count_non==0) {
            System.out.println(answer);
            return;
        }
        bfs();
        if(count_non!=0) answer=0;
        System.out.println(answer-1);

    }
    static void bfs(){
        Node temp;
        int size, nz,ny,nx;
        while(!queue.isEmpty()){
            size = queue.size();
            answer++;
            for(int i=0;i<size;i++){
                temp = queue.poll();
                for(int j=0;j<6;j++){
                    nz = temp.z+dz[j];
                    ny = temp.y+dy[j];
                    nx = temp.x+dx[j];
                    if(nz<0||ny<0||nx<0||nz>=H||ny>=N||nx>=M) continue;
                    if(box[nz][ny][nx] != 0) continue;
                    box[nz][ny][nx] = answer;
                    count_non--;
                    queue.offer(new Node(nz, ny, nx));
                }
            }
        }
    }
    static class Node{
        int y,x,z;
        Node(int z,int y, int x){
            this.y=y;
            this.x=x;
            this.z=z;
        }
    }
}
