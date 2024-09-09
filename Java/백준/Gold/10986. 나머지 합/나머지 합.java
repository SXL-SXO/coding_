import java.util.*;
import java.io.*;


public class Main
{
    static int N, M;
    static Long answer = 0L;
    static int input[], sum[];
    static int div[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum = new int[N];
		div = new int[M];
	    
		st = new StringTokenizer(br.readLine());
		sum[0] = Integer.parseInt(st.nextToken())%M;
		div[sum[0]]++;
		for(int i=1;i<N;i++){
		    sum[i] = (sum[i-1] + Integer.parseInt(st.nextToken()))%M;
		    div[sum[i]]++;
		}
		
		for(int i=0;i<M;i++){
		    if(div[i]>=2) answer += Long.valueOf((div[i]-1))*Long.valueOf(div[i]);
		}
		answer /= 2;
		answer += div[0];
		System.out.print(answer);
	}
}
