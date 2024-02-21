import java.io.*;
import java.util.*;

public class 동전0_11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] coin = new int[N];
        for(int i=0;i<N;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N-1;i>-1;i--){
            answer += K/coin[i];
            K %=coin[i];
        }
        System.out.println(answer);
    }
}
