import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int input[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int count_m = 0;
		for(int i=0;i<N;i++){
		    input[i] = Integer.parseInt(st.nextToken());
		    if(input[i]<0) count_m++;
		}
		
		Arrays.sort(input);
		
		int answer = 0;
		// 무조건 절댓값이 큰 순서로 + 해줌
		
		for(int i = 0;i<count_m;i+=M){
		    answer += Math.abs(input[i])*2;
		}
		for(int i = N-1;i>=count_m;i-=M){
		    answer += Math.abs(input[i])*2;
		}
		
		System.out.print(answer-Math.max(Math.abs(input[0]), Math.abs(input[N-1])));
	}
}
