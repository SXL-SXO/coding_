import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++){
		    input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		
		int front = 0, back = N-1, answer = Math.abs(input[N-1]+input[0]);
		sb.append(input[front]).append(" ").append(input[back]);
		while(front<back){
		    if(answer > Math.abs(input[front]+input[back])){
		        answer = Math.abs(input[front]+input[back]);
		        sb.setLength(0);
		        sb.append(input[front]).append(" ").append(input[back]);
		    }
		    if(front+1>=N) back++;
		    else if(back-1<0) front++;
		    else if(Math.abs(input[front+1]+input[back])<Math.abs(input[front]+input[back-1])) front++;
		    else back--;
		}
		
		System.out.print(sb);
	}
}
