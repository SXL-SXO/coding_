import java.io.*;
import java.util.*;

//최대공약수

public class B_카잉달력_6064 {
    static int T, N, M, X, Y, nY, nX, answer, max;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            nX = X; nY = Y; 
            if(X<Y){
                nY = answer = X;
                check(true);
            }else{
                nX = answer = Y;
                check(false);
            }

            if(nX==X && nX==Y) sb.append(answer).append("\n");
            else sb.append(-1).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void check(boolean type){
        boolean visit[];
        if(nX==X && nY==Y) return;
        if(type){
            visit = new boolean[N+1];
            while(true){
                nY+=M;
                answer+=M;
                if(nY%N==Y||visit[nY%N]) return;
            }
        }else{
            visit = new boolean[M+1];
            while(true){
                nX+=N;
                answer+=N;
                if(nX%M==X||visit[nX%M]) return;
            }
        }

    }
}
