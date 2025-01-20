import java.util.*;
import java.io.*;

public class Main
{
	static int N, M;
	static int input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N+1];
		for(int i=0; i<=N; i++) {
			input[i] = i;
		}
		int a, b, c;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			a = check(Integer.parseInt(st.nextToken()));
			b = check(Integer.parseInt(st.nextToken()));
			
			if(c==1){
				if(a==b) sb.append("yes\n");
				else sb.append("no\n");
			}else
				input[a] = b;
			
		}
		System.out.print(sb);
	}
	static int check(int num){
	    if(input[num]==num) return input[num];
	    else return input[num] = check(input[num]);
	}
}
