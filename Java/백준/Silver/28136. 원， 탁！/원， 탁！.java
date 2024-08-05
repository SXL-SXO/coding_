import java.util.*;
import java.io.*;

public class Main
{
	static int N, answer = 0;
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		input = new int[N];
		input[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(input[i-1]>=input[i]) answer++;
		}
        if(input[N-1]>=input[0]) answer++;
		System.out.println(answer);
	}
}
