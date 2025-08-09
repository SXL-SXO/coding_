import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int N, M, W = 0, B = 0;
    static boolean visit[][];
    static char input[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Queue<Integer> queue = new ArrayDeque<Integer>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        input = new char[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) input[i] = br.readLine().toCharArray();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visit[i][j]) {
                    visit[i][j] = true;
                    queue.offer(i*M+j);

                    if(input[i][j] == 'W') W += check(input[i][j]);
                    else B += check(input[i][j]);
                }
            }
        }
        System.out.println(W+" "+B);
    }
    static int check(char c){
        int temp, ny, nx, count = 0;
        while(!queue.isEmpty()){
            temp = queue.poll();
            count++;

            for(int i=0;i<4;i++){
                ny = temp/M + dy[i];
                nx = temp%M + dx[i];

                if(ny<0 || ny>=N || nx<0 || nx>=M || visit[ny][nx] || c!=input[ny][nx]) continue;
                visit[ny][nx] = true;
                queue.offer(ny*M+nx);
            }
        }
        return count*count;
    }
}