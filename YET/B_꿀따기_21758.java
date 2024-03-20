import java.io.*;
import java.util.*;

public class B_꿀따기_21758 {
    static int N, total = 0, total_r = 0, total_l = 0, answer = 0;
    static int input[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
            total += input[i];
        }

        total_r=total+input[0]-input[N-1];
        total_l=total;
        total-=(input[0]+input[N-1]);

        for(int i=1;i<N-1;i++){
            answer = Math.max(answer, total+input[i]);

            answer = Math.max(answer, total+total_l-input[0]*2-input[i]*2);
            total_l-=input[i];

            answer = Math.max(answer, total+total_r-input[N-1]*2-input[N-1-i]*2);
            total_r-=input[N-1-i];
        }

        System.out.println(answer);
    }
}
