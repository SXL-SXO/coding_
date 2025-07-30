import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int R, C, N;
    static int stick[];
    static char map[][];
    static boolean visit[][];
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R  = Integer.parseInt(st.nextToken());
        C  = Integer.parseInt(st.nextToken());

        map = new char[R][];
        for(int i=0;i<R;i++){
            map[i] = br.readLine().toCharArray();
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        stick = new int[N];
        for(int i=0;i<N;i++){
            stick[i] = Integer.parseInt(st.nextToken());
        }

        for(int k=0;k<N;k++){
            throw_stick(k%2==0, R-stick[k]);

//            for(int i=0;i<R;i++){
//                for(int j=0;j<C;j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println("");
//            }
        }

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void down(){
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(visit[i][j]) queue.offer(i*C+j);
            }
        }

        int temp, size = queue.size(), y, x, count = R;
        for(int s=0;s<size;s++){
            temp = queue.poll();
            y = temp/C;
            x = temp%C;
            map[y][x] = '.';
            for(int k=1;k<R;k++){
                if(y+k == R || (!visit[y+k][x] &&map[y+k][x] == 'x')){
                    count = Math.min(count,k-1);
                    break;
                }
            }
//            System.out.println(temp);
            queue.offer(temp);
        }
//        System.out.println("c : "+count);
        for(int s=0;s<size;s++) {
            temp = queue.poll();
            y = temp / C;
            x = temp % C;
            map[y+count][x] = 'x';
        }
    }
    static boolean check(int i, int j, int dir){
        int temp, ny = i+dy[dir], nx = j+dx[dir];

        if(ny<0 || ny>=R-1 || nx<0 || nx>=C || map[ny][nx] == '.') return false;

        visit = new boolean[R][C];
        visit[i][j] = true;
        visit[ny][nx] = true;
        queue.clear();
        queue.offer(ny*C + nx);

        while(!queue.isEmpty()){
            temp = queue.poll();

            for(int k=0;k<4;k++){
                ny = temp/C+dy[k];
                nx = temp%C+dx[k];

                if(ny<0 || nx<0 || nx>=C || map[ny][nx] == '.' || visit[ny][nx]) continue;
                else if(ny==R-1) return false;

                visit[ny][nx] = true;
                queue.offer(ny*C + nx);
            }
        }
        visit[i][j] = false;
        down();
        return true;
    }
    static void throw_stick(boolean type, int i){
        if(type){
            for(int j=0;j<C;j++) {
                if (map[i][j] == 'x') {
                    map[i][j] = '.';
                    if(check(i, j, 0) || check(i, j, 1) || check(i, j, 2)) return;
                    return;
                }
            }
        }
        else {
            for(int j=C-1;j>=0;j--) {
                if(map[i][j]=='x') {
                    map[i][j] = '.';
                    check(i, j, 0);
                    check(i, j, 2);
                    check(i, j, 3);
                    return;
                }
            }
        }
    }
}