import java.io.*;
import java.util.*;

public class B_테트로미노_14500 {
    static int N, M, answer, mask;
    static int map[][];
    static int dy[] = {-1,0,1,0}; //상 좌 하 우
    static int dx[] = {0,1,0,-1}; //상 좌 하 우
    //static 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer=0;
        for(int a=0;a<N;a++){
            for(int b=0;b<M;b++){
                mask = 0;
                for(int i=1;i<=3;i++){
                    mask=i;
                    for(int j=1;j<=3;j++){
                        mask=mask*10+j;
                        for(int k=1;k<=3;k++){

                            mask=mask*10+k;
                            visit_OLYI(a,b);
                            mask/=10;
                        }
                        mask/=10;
                    }
                }
                visit_T(a,b);
            }
        }
        System.out.println(answer);
    }
    static void visit_T(int a, int b){
        int count=map[a][b], ny, nx;
        boolean type = false;
        for(int i=0;i<4;i++){
            ny=a+dy[i];
            nx=b+dx[i];
            if(check(ny,nx)) {type= true;continue;}
            count+=map[ny][nx];
        }
        if(type) {answer = Math.max(count, answer); return;}
        for(int i=0;i<4;i++){
            answer = Math.max(count-map[a+dy[i]][b+dx[i]], answer);
        }
    }
    static void visit_OLYI(int i, int j){
        int count = map[i][j], mask_ = mask;
        int n[][] = new int[4][2];
        n[0][0] = i; n[0][1] = j;
        for(int k=1;k<4;k++){
            if((mask_/10%10)*(mask_%10)==3) return;
            n[k][0] = n[k-1][0]+dy[mask_%10];
            n[k][1] = n[k-1][1]+dx[mask_%10];
            if(check(n[k][0], n[k][1])) return;
            count += map[n[k][0]][n[k][1]];
            mask_ /= 10;
        }
        
        // for(int k=0;k<4;k++)
        // System.out.print(Arrays.toString(n[k])+" ");
        // System.out.println(" ");
        if(answer<count) {
            answer = count;
        }
    }
    static boolean check(int y, int x){
        if(y>=N||y<0||x>=M||x<0) return true;
        return false;
    }
}

