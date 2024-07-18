import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int N, M, answer = 0;
   static char map[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][];
        for(int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }

        answer = check(0,0,1,new boolean['Z'-'A'+1]);
        
        System.out.println(answer);
    }
    static int check(int y, int x, int c, boolean visit[]){
        int ny, nx, re = c;
        
        visit[map[y][x]-'A'] = true;
        for (int i = 0; i < 4; i++) {
            ny = y + dy[i];
            nx = x + dx[i];
            if (ny >= N || ny < 0 || nx >= M || nx < 0 || visit[map[ny][nx]-'A'] ) continue;
            re = Math.max(re,check(ny, nx, c+1, visit));
        }
        visit[map[y][x]-'A'] = false;
        
        return re;
    }
}