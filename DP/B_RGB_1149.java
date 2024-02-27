import java.io.*;
import java.util.*;

public class B_RGB_1149 {
    static int memoi[][];
    static int N, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        memoi = new int[N][3];

        st = new StringTokenizer(br.readLine());
        memoi[0][0] = Integer.parseInt(st.nextToken());
        memoi[0][1] = Integer.parseInt(st.nextToken());
        memoi[0][2] = Integer.parseInt(st.nextToken());

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            memoi[i][0] = Integer.parseInt(st.nextToken());
            memoi[i][1] = Integer.parseInt(st.nextToken());
            memoi[i][2] = Integer.parseInt(st.nextToken());
            memoi[i][0] += Math.min(memoi[i-1][1], memoi[i-1][2]);
            memoi[i][1] += Math.min(memoi[i-1][0], memoi[i-1][2]);
            memoi[i][2] += Math.min(memoi[i-1][0], memoi[i-1][1]);
        }

        answer = memoi[N-1][0];
        for(int i=1;i<3;i++){
            answer = Math.min(answer,memoi[N-1][i]);
        }
        System.out.println(answer);
    }
}
