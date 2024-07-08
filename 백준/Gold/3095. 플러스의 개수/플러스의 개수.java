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
                if(visit[i][j] || map[i][j]!='1' || map[i-1][j]!='1' || map[i][j-1]!='1' || map[i+1][j]!='1' || map[i][j+1]!='1' || map[i - 1][j - 1] == '1' || map[i - 1][j + 1] == '1' || map[i + 1][j - 1] == '1' || map[i + 1][j + 1] == '1')
                    continue;
                answer++;
                check(i, j);            
            }
        }

        System.out.println(answer);
    }
    static void check(int i, int j){
        for(int a=i-1;a<=i+1;a++){
            for(int b=j-1;b<=j+1;b++){
                visit[a][b] = true;
            }
        }
        total : for(int mul = 2;;mul++){
            if(i-mul<0 || j-mul<0 || i+mul>=N || j+mul>=N) break;
            for(int a=-mul;a<=mul;a++){
                if(a!=0 && ((map[i+a][j-mul] != '0' || map[i+a][j+mul] != '0') || (map[i-mul][j+a] != '0' || map[i+mul][j+a] != '0'))) break total;
            }
            for(int a=-mul;a<=mul;a++){
                visit[i+a][j-mul] = true;
                visit[i+a][j+mul] = true;
                visit[i-mul][j+a] = true;
                visit[i+mul][j+a] = true;
            }
            answer++;
        }
    }
}