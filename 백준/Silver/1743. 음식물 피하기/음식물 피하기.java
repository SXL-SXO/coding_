import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K,answer = 0;
    static boolean visit[][];

    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[N][M];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            visit[A][B] = true;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visit[i][j]) {
                    visit[i][j] = false;
                    check(i*M+j);
                }
            }
        }
        System.out.println(answer);
    }
    static void check(int yx){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(yx);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            count += size;
            for(int i=0;i<size;i++){
                int temp = queue.poll();
                int y = temp/M, x = temp%M;
                for(int j=0;j<4;j++){
                    int ny = y+dy[j];
                    int nx = x+dx[j];
                    if(ny>=N||ny<0||nx>=M||nx<0||!visit[ny][nx]) continue;
                    visit[ny][nx] = false;
                    queue.offer(ny*M+nx);
                }
            }
        }
        answer = Math.max(answer, count);
    }
}
