import java.io.*;
import java.util.*;

public class 이항계수2_11051 {
    static int c[][] = new int[1001][1001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        K = N-K<K ? N-K:K;

        
        int answer = comb(N,K);
        System.err.println(answer);
    }
    static int comb(int n,int k){
        if(c[n][k]>0) return c[n][k];
        if(n==k || k==0) {
            c[n][k] = 1;
            return 1;
        }
        c[n][k] = (comb(n-1,k)+comb(n-1,k-1))%10007;

        return c[n][k];
    }
}
