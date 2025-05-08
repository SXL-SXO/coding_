import java.io.*;
import java.util.*;

public class Main {
	
	static int[] box, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); // 박스의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 박스의 크기를 저장할 배열
		box = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		// 박스를 겹칠때 겹쳐진 수를 표기하는 배열
		dp = new int[n + 1];
		dp[1] = 1;
		
		// find() 호출해서 가장 많이 들어가는 박스의 수를 찾는다.
		for (int i = 2; i <= n; i++) {
			dp[i] = find(i) + 1;
		}
		
		// 가장 많이 겹쳐진 박스의 값을 출력
		int count = 0;
		for (int m : dp) {
			count = Math.max(count, m);
		}
		
		bw.write(Integer.toString(count));
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 현재 박스에 가장 많이 들어갈 수 있는 박스의 수를 찾아주는 함수.
	private static int find(int num) {
		int max = 0;
		for (int i = num - 1; i > 0; i--) {
			if (box[i] < box[num]) {
				max = Math.max(max, dp[i]);
			}
		}
		
		return max;
	}
}