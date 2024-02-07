package ss_study;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 보이저1호_3987 {
    static Deque<int[]> visit = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char space[][] = new char[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                space[i][j] = st.nextToken().charAt(0);
            }
        }
        st = new StringTokenizer(br.readLine());
        int start[] = new int[2];
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());

        visit.offer(start);
        go(start);
    }
    static void go (int s[]){
        if()
    }
}
