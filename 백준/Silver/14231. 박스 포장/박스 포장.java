import java.io.*;
import java.util.*;

public class Main {
	static int N, answer = 0;
	static int[] box, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		box = new int[N + 1];
		dp = new int[N + 1];
		dp[1] = 1;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= N; i++) {
			dp[i] = find(i) + 1;
		}
		
		for (int m : dp) {
			answer = Math.max(answer, m);
		}
		
		System.out.print(answer);
	}
	
	static int find(int num) {
		int max = 0;
		for (int i = num - 1; i > 0; i--) {
			if (box[i] < box[num]) {
				max = Math.max(max, dp[i]);
			}
		}
		
		return max;
	}
}