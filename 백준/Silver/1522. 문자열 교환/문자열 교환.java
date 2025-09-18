import java.util.*;
import java.io.*;
public class Main
{
	static int N, A = 0, B = 0, answer = 0;
	static char input[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sb.append(br.readLine());
		answer = N = sb.length();
		for(int i=0;i<N;i++) {
		    if(sb.charAt(i)=='a') A++;
			else B++;
		}
        if(A==0 || B==0 || A==1 || B==1) {
            System.out.print(0);
            return;
        }
        
		int count;
		for(int j=0; j<N; j++) {
		    count = 0;
			while(sb.charAt(0) == sb.charAt(N-1)) {
				sb.append(sb.charAt(0));
				sb.deleteCharAt(0);
				j++;
			}

			input = sb.toString().toCharArray();
			if(A<B && input[0] =='a') {
				for(int i=1; i<A; i++) {
					if(input[i] != 'a') count++;
				}
			} else if(A<B && input[0] =='b') {
				for(int i=1; i<A; i++) {
					if(input[N-1-i] != 'a') count++;
				}
			} else if(input[0] =='a') {
				for(int i=1; i<B; i++) {
					if(input[N-1-i] != 'b') count++;
				}
			} else {
				for(int i=1; i<B; i++) {
					if(input[i] != 'b') count++;
				}
			}
			
			sb.append(sb.charAt(0));
			sb.deleteCharAt(0);
			answer = Math.min(answer, count);
		}
		System.out.print(answer);
	}
}