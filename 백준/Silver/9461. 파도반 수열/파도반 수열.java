import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static Long dp[] = new Long [101];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        for(int i=4;i<101;i++){
            dp[i] = dp[i-2]+dp[i-3];
        }
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
