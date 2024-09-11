import java.util.*;
import java.io.*;

public class Main
{
    static int N, max = 0;
    static int input[], answer[], num[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		answer = new int[1_000_001];
		num = new int[1_000_001];
		for(int i=0;i<N;i++){
		    input[i] = Integer.parseInt(br.readLine());
		    num[input[i]]++;
		    max = Math.max(max, input[i]);
		}
		
		visit = new boolean[max+1];
		for(int i=0;i<N;i++){
		    if(visit[input[i]]) continue;
		    visit[input[i]] = true;
		    answer[input[i]]--;
		    for(int j=input[i];j<=max;j+=input[i]){
		        answer[j]+=num[input[i]];
		    }
		}
		for(int i=0;i<N;i++){
		    sb.append(answer[input[i]]).append("\n");
		}
		System.out.print(sb);
		
	}
}
