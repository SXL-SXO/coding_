import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int input[][];
    static boolean visit[][];
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    input = new int[N][M];
	    visit = new boolean[N][M];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<M;j++){
	            input[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    if(N==1 && M==1){
	        System.out.print("Yes");
	        return;
	    }
	    if(bfs()) System.out.print("Yes");
	    else System.out.print("No");
	}
	static boolean bfs(){
	    int temp;
	    
	    visit[0][0] = true;
	    queue.offer(0);
	        
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        if(temp/M==N-1 && temp%M==M-1) return true;
	        
	        if(temp%M != M-1 && !visit[temp/M][temp%M+1] && input[temp/M][temp%M+1]==1) {
	            visit[temp/M][temp%M+1] = true;
	            queue.offer(temp+1);
	        }if(temp/M != N-1 && !visit[temp/M+1][temp%M] && input[temp/M+1][temp%M]==1) {
	            visit[temp/M+1][temp%M] = true;
	            queue.offer(temp+M);
	        }
	    }
	    return false;
	}
    
}
