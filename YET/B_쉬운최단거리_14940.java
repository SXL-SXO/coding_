import java.io.*;
import java.util.*;

public class B_쉬운최단거리_14940 {
    static int N, M;
    static int map[][];
    static int answer[][];
    static Node end;

    static StringBuilder sb = new StringBuilder();
    static Queue<Node> queue = new ArrayDeque<>();

    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            Arrays.fill(answer[i], -1);
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j]==2) end = new Node(i, j);
                else if(map[i][j]==0) answer[i][j] = 0;
            }
        }
        queue.offer(end);
        Node temp;
        int count = 0, size, ny, nx;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i=0;i<size;i++){
                temp = queue.poll();
                
                answer[temp.y][temp.x] = count;
                for(int j=0;j<4;j++){
                    ny = temp.y + dy[j];
                    nx = temp.x + dx[j];
                    if(ny>=N || ny<0 || nx>=M || nx<0 ) continue;
                    else if(map[ny][nx] != 1 || answer[ny][nx]!= -1) continue;
                    answer[ny][nx] = -2;
                    queue.offer(new Node(ny, nx));
                }
            }
            count++;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    static class Node{
        int y, x;
        Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
}
