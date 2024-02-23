package Feb_20;

import java.io.*;
import java.util.*;

public class B_적록색약_10026_teacher1 {
    static int dy[] = new int[] {-1,1,0,0 };
    static int dx[] = new int[] {0,0,-1,1 };
    static int answer_1=0, answer_2=0, N;
    static char [][] color;
    static boolean [][] visit1, visit2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        N = Integer.parseInt(br.readLine());
        color = new char[N][];
        visit1 = new boolean[N][N];
        visit2 = new boolean[N][N];
        for(int i=0;i<N;i++){
            color[i] = br.readLine().toCharArray();
        }

        // 정상인의 시야 R / G / B (1,2,3)
        // 색맹의 시야 B / R+G (3,4)
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit1[i][j]) {// 방문하지않았다면, 일반
                    dfs(i,j);
                    answer_1+=1;
                }
                if(!visit2[i][j]) {// 방문하지않았다면, 적록색약
                    dfs2(i,j);
                    answer_2+=1;
                }
            }
        }
        System.out.println(answer_1+" "+answer_2);
    }
    
    //현재 y, x로 부터 갈 수 있는 곳을 방문을 이어가면서 visit
    static void dfs(int y,int x){
    	visit1[y][x] = true;
        int ny,nx;
        for(int a=0;a<4;a++){
            ny = y+dy[a];
            nx = x+dx[a];
            if(ny>=N||ny<0||nx>=N||nx<0||visit1[ny][nx]||color[y][x]!=color[ny][nx]) continue;
            dfs(ny,nx);       
        }
    }
    static void dfs2(int y,int x){
    	visit2[y][x] = true;
        int ny,nx;
        for(int a=0;a<4;a++){
            ny = y+dy[a];
            nx = x+dx[a];
            if(ny>=N||ny<0||nx>=N||nx<0||visit2[ny][nx]) continue;
            if((color[y][x]!='B'&&color[ny][nx]=='B')||(color[y][x]=='B'&&color[ny][nx]!='B')) continue;
            dfs2(ny,nx);       
        }
    }
}
