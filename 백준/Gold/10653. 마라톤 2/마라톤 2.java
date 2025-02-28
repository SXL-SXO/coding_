import java.util.*;
import java.io.*;
public class Main
{
    static Node input[];
    static int move[][], dp[][];
    static int N, K;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    input = new Node[N];
	    move = new int[N][N];
	    dp = new int[N][K+1];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	        Arrays.fill(dp[i], 1000000);
	    }
	    if(K>=N-2){
	        System.out.print(Math.abs(input[N-1].y-input[0].y)+Math.abs(input[N-1].x-input[0].x));
	        return;
	    }
	    dp[0][0] = 0;
	    for(int i=1;i<N;i++){
	        for(int k=K; k>=0; k--){
                if(i-1<k) continue;
	            for(int a=k; a>=0; a--){
    	            dp[i][k] 
    	                = Math.min(dp[i][k], dp[i-1-a][k-a] + Math.abs(input[i-1-a].y-input[i].y)+Math.abs(input[i-1-a].x-input[i].x));
	            }
    	    }
	    }
	    // dp[현재 포인트][점프한 총 횟수]
	   // 점프한 총 횟수가 k 일때 i에서의 최소 값
	   // a 만큼 점프한 녀석 + b 만큼 점프한 녀석
	   // = dp[i-k-1-a][a] + input[i-k-1-a].y-input[i].y
	    
	    
		System.out.println(dp[N-1][K]);
	}
	static class Node{
	    int y, x;
	    Node(int y, int x){
	        this.y=y;
	        this.x=x;
	    }
	}
}

