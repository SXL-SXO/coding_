import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static int N, answer = 0;
    static char map[][];
    static boolean visit[][];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][];
        visit = new boolean[N][N];
        for(int i=0;i<N;i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=1;i<N-1;i++){
            for(int j=1;j<N-1;j++){
                if(visit[i][j]) continue;
                if(map[i][j]=='1' && map[i-1][j]=='1' && map[i][j-1]=='1' && map[i+1][j]=='1' && map[i][j+1]=='1' ) {
                    if (map[i - 1][j - 1] == '1' || map[i - 1][j + 1] == '1' || map[i + 1][j - 1] == '1' || map[i + 1][j + 1] == '1')
                        continue;
                    answer++;
                    check(i, j);
                }
            }
        }

        System.out.println(answer);
    }
    static void check(int i, int j){
        int ny, nx, mul=2;
        total : for(;;mul++){
            if(i-mul<0 || j-mul<0 || i+mul>=N || j+mul>=N) break;
            for(int a=i-mul;a<=i+mul;a++){

                if(a==i) continue;
//                System.out.print(a+" "+(j-mul)+" / ");
//                System.out.println(a+" "+(j+mul)+" / ");
                if(map[a][j-mul] != '0' || map[a][j+mul] != '0') break total;
            }
//            System.out.println("행가능");
            for(int a=j-mul;a<j+mul;a++){
                if(a==j) continue;
                if(map[i-mul][a] != '0' || map[i+mul][a] != '0') break total;
            }
//            System.out.println("열가능");

            answer++;
        }
        mul--;
        for(int a=i-mul;a<=i+mul;a++){
            for(int b=j-mul;b<=j+mul;b++){
                visit[a][b] = true;
            }
        }
    }
}