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
		
		for(int i=0;i<N;i++){
		    input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int answer = 0;
		for(int i = 0;i<N;i+=M){
		    if(input[i]>0) break;
		    answer += Math.abs(input[i])*2;
		}
		for(int i = N-1;i>=0;i-=M){
		    if(input[i]<0) break;
		    answer += Math.abs(input[i])*2;
		}
		
		System.out.print(answer-Math.max(Math.abs(input[0]), Math.abs(input[N-1])));
	}
}
