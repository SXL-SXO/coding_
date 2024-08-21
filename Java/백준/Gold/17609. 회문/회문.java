import java.util.*;
import java.io.*;
public class Main
{
	static int T;
	static char input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			input = br.readLine().toCharArray();
			sb.append(check(0, input.length-1, 0)).append("\n");
		}
		System.out.print(sb);
	}
	static int check(int start, int end, int type) {
		while(start<=end) {
			if(input[start]!=input[end]) {
			    if (type == 0) return 1 + (check(start+1, end, 1) & check(start, end-1, 1));
			    else if(type == 1) return 1;
			}
			start++;
			end--;
		}
		return 0;
	}
}
