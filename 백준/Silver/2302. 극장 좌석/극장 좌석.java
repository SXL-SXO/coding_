import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int N,M,VIP,start=0;
    static Long dp[] = new Long[41];
    static Long answer = 1L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dp[0] = 1L;
        dp[1] = 1L;
        for(int i=2;i<41;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        for(int i=0;i<M;i++){
            VIP = Integer.parseInt(br.readLine());
            answer *= dp[VIP-start-1];
            start = VIP;
        }
        answer *= dp[N-start];
        System.out.println(answer);
    }
}