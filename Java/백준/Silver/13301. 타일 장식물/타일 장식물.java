import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static long answer[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new long[N+1];
		
		answer[0] = 1L;
		answer[1] = 1L;
		for(int i=2;i<=N;i++){
		    answer[i] = answer[i-1]+answer[i-2];
		}
		System.out.print(answer[N]*2+answer[N-1]*2);
	}
}
