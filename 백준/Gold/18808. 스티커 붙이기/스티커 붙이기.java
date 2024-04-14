import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N, M, K, A, B, answer = 0;
    static boolean map[][], stick[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            stick = new boolean[A][B];
            for (int a = 0; a < A; a++) {
                st = new StringTokenizer(br.readLine());
                for (int b = 0; b < B; b++) {
                    stick[a][b] = st.nextToken().equals("1");
                }
            }
            put_sticker();
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j]) answer++;
            }
        }
        System.out.println(answer);
    }
    static void put_sticker() {
        // 0 도
        for(int i=0; i <= N-A; i++) {
            for(int j=0; j <= M-B; j++) {
                if(check_0(i,j)) return;
            }
        }
        // 90도
        for(int i=0; i <= N-B; i++) {
            for(int j=0; j <= M-A; j++) {
                if(check_1(i,j)) return;
            }
        }
        // 180 도
        for(int i=0; i <= N-A; i++) {
            for(int j=0; j <= M-B; j++) {
                if(check_2(i,j)) return;
            }
        }
        // 270도
        for(int i=0; i <= N-B; i++) {
            for(int j=0; j <= M-A; j++) {
                if(check_3(i,j)) return;
            }
        }
    }
    static boolean check_0(int i, int j) {
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                if(map[i+a][j+b]&&stick[a][b]) return false;
            }
        }
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                map[i+a][j+b] = map[i+a][j+b]|stick[a][b];
            }
        }
        return true;
    }
    static boolean check_1(int i, int j) {
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                if(map[i+b][j+A-1-a]&&stick[a][b]) return false;
            }
        }
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                map[i+b][j+A-1-a] = map[i+b][j+A-1-a]|stick[a][b];
            }
        }
        return true;
    }
    static boolean check_2(int i, int j) {
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                if(map[i+A-1-a][j+B-1-b]&&stick[a][b]) return false;
            }
        }
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                map[i+A-1-a][j+B-1-b] = map[i+A-1-a][j+B-1-b]|stick[a][b];
            }
        }
        return true;
    }
    static boolean check_3(int i, int j) {
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                if(map[i+B-1-b][j+a]&&stick[a][b]) return false;
            }
        }
        for(int a=0;a<A;a++){
            for(int b=0;b<B;b++){
                map[i+B-1-b][j+a] = map[i+B-1-b][j+a]|stick[a][b];
            }
        }
        return true;
    }

}