package Feb_20;

import java.io.*;
import java.util.*;

public class B_적록색약_10026_me {
    static int dy[] = new int[] {-1,1,0,0 };
    static int dx[] = new int[] {0,0,-1,1 };
    static int answer_1=0, answer_2=0, N;
    static char color[][];
    static boolean visit[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        N = Integer.parseInt(br.readLine());
        color = new char[N][N];
        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            s = br.readLine();
            for(int j=0;j<N;j++){
                color[i][j] = s.charAt(j);
            }
        }

        // 정상인의 시야 R / G / B (1,2,3)
        // 색맹의 시야 B / R+G (3,4)
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]) {// 방문하지않았다면
                    check(i,j,color[i][j]);
                    answer_1+=1;
                }
            }
        }
        
        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]) {// 방문하지않았다면
                    check_1(i,j,color[i][j]);
                    answer_2+=1;
                }
            }
        }
        System.out.println(answer_1+" "+answer_2);
    }
    static void check(int i,int j, char c){
        int y,x;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(i,j));
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(int a=0;a<4;a++){
                y = temp.y+dy[a];
                x = temp.x+dx[a];
                if(y>=N||y<0||x>=N||x<0||visit[y][x]) continue;
                if(color[y][x]!=c) continue;
                queue.offer(new Node(y, x));
                visit[y][x] = true;
            }
        }
    }
    static void check_1(int i,int j, char c){
        int y,x;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(i,j));
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(int a=0;a<4;a++){
                y = temp.y+dy[a];
                x = temp.x+dx[a];
                if(y>=N||y<0||x>=N||x<0||visit[y][x]) continue;
                if((color[y][x]=='B'&&c!='B')||(color[y][x]!='B'&&c=='B')) continue;
                queue.offer(new Node(y, x));
                visit[y][x] = true;
            }
        }
    }
    static class Node{
        int y,x;
        Node(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
}
