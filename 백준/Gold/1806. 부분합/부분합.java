import java.util.*;
import java.io.*;
public class Main
{
    static int input[];
    static int N, S, answer, start=0, total = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		answer = N+1;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    input[i] = Integer.parseInt(st.nextToken());
            total += input[i];
            if(total>=S){
        		while(total >= S){
        			total -= input[start++];
        		}
    		    answer = Math.min(answer, i + 2 - start);
    		}
        }

        if(answer == N+1) answer = 0;
		System.out.print(answer);
    }
}
