import java.util.*;
import java.io.*;

public class Main
{
    static int N, T;
    static int dp[];
    static Node input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    T = Integer.parseInt(st.nextToken());
	    
	    dp = new int[T+1]; // 시간별로 했을 때 최대 점수
	    input = new Node[N];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	       // dp[input[i][0]] = Math.max(dp[input[i][0]], dp[input[i][1]]);
	    }
	    Arrays.sort(input, (o1, o2)-> o1.t-o2.t);
	    
	    for(int i=0;i<N;i++){
	        for(int j=T; j>=input[i].t; j--){
	            dp[j] = Math.max(dp[j], dp[j-input[i].t]+input[i].s);
	        }
	    }
	    
	    
		System.out.println(dp[T]);
	}
	static class Node{
	    int t, s;
	    Node(int t, int s){
	        this.t=t;
	        this.s=s;
	    }
	}
}
