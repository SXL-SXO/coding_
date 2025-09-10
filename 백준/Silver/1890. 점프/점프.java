import java.util.*;
import java.io.*;

public class Main
{
    static int N; 
    static int input[][];
    static long dp[][];
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[N][N];
	    dp = new long[N][N];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<N;j++) input[i][j] = Integer.parseInt(st.nextToken());
	    }
	    
	    bfs();
	    
	   // for(int i=0;i<N;i++) System.out.println(Arrays.toString(dp[i]));
	    
		System.out.println(dp[N-1][N-1]);
	}
	static void bfs(){
	    int y, x, ny, nx;
	    
	    dp[0][0] = 1;
	    
	    for(int i=0;i<N*2-2;i++){
	        y = i>=N ? i-N+1 : 0;
	        x = i>=N ? N-1 : i;
	        
	        while(x>=0 && y<N){
	           // System.out.println(y+" "+x);
	            ny = y + input[y][x];
	            nx = x;
	            if(ny<N) dp[ny][nx] += dp[y][x];
	            
	            ny = y;
	            nx = x + input[y][x];
	            if(nx<N) dp[ny][nx] += dp[y][x];
	            
	            x--;
	            y++;
	        }
	    }
	}
}
