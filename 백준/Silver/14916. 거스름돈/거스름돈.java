import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int [N+1];

		if(N==1 || N==3) {
			System.out.print(-1);
			return;
		} else if(N==2||N==5) {
			System.out.print(1);
			return;
		} else if(N==4) {
			System.out.print(2);
			return;
		}

		dp[1] = Integer.MAX_VALUE-1;
		dp[2] = 1;
		dp[3] = Integer.MAX_VALUE-1;
		dp[4] = 2;
		dp[5] = 1;

		for(int i=6; i<=N; i++) {
			dp[i] = Math.min(dp[i-5], dp[i-2]) + 1;
		}
        System.out.print(dp[N]);
	}
}
