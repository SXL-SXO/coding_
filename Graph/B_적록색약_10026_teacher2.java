package Feb_20;

import java.io.*;
import java.util.*;

public class B_적록색약_10026_teacher2 {
    static int dy[] = new int[] {-1,1,0,0 };
    static int dx[] = new int[] {0,0,-1,1 };
    static int answer_1=0, answer_2=0, N;
    static char [][] color;
    static boolean [][] visit1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        N = Integer.parseInt(br.readLine());
        color = new char[N][];
        visit1 = new boolean[N][N];
        for(int i=0;i<N;i++){
            color[i] = br.readLine().toCharArray();
        }

        // 정상인의 시야 R / G / B (1,2,3)
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit1[i][j]) {// 방문하지않았다면, 일반
                    dfs(i,j);
                    answer_1+=1;
                }
            }
        }
        
        // map에서 R = G로 전부 변경, visit 초기화
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(color[i][j]=='R') color[i][j]='G';
            }
        }
        
        visit1 = new boolean[N][N];
        // 색맹의 시야 B / R+G (3,4)
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit1[i][j]) {// 방문하지않았다면, 일반
                    dfs(i,j);
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
}
