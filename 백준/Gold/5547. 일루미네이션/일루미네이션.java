import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer = 0;
    static boolean input[][], visit[][];
    static int dy[] = {-1, -1, 0, 1, 1, 0};
    static int dx[][] = {{0, 1, 1, 1, 0, -1},{-1, 0, 1, 0, -1, -1}};
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    input = new boolean[N][M];
	    visit = new boolean[N][M];
	    
	    if(N==1 || M==1){
	        for(int i=0;i<N;i++){
    	        st = new StringTokenizer(br.readLine());
    	        for(int j=0;j<M;j++){
    	            input[i][j] = st.nextToken().charAt(0) == '1';
    	            if(input[i][j]) answer += 6;
    	        }
	        }
	        
	        for(int i=1;i<N;i++) if(input[i-1][0] && input[i][0]) answer --;
	        for(int j=1;j<M;j++) if(input[0][j-1] && input[0][j]) answer --;
	        
	        System.out.print(answer);
	        return;
	    }
	    
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<M;j++){
	            input[i][j] = st.nextToken().charAt(0) == '1';
	            if(input[i][j]){
	                if(i==0 || i==N-1) answer += 2;
	                
	                if(i%2==0 && j==0) answer += 1;
	                else if(i%2==0 && j==M-1) answer += 3;
	                else if(i%2==1 && j==0) answer += 3;
	                else if(i%2==1 && j==M-1) answer += 1;
	                
	                if((i==0 && j==M-1) || (i==N-1 && i%2==1 && j==0)) answer -= 1;
	                
	               // System.out.print(answer+" ");
	            }
	        }
	    }
	    
	    
	    for(int i=0;i<N;i++){
	        if(i==0 || i==N-1) {
	            for(int j=0;j<M;j++){
	                if(!input[i][j] && !visit[i][j]) {
                        queue.offer(i*M+j);
                        bfs();
                    }
	            }
	        }else if(!input[i][0] && !visit[i][0]) {
                queue.offer(i*M);
                bfs();
            }else if(!input[i][M-1] && !visit[i][M-1]) {
                queue.offer(i*M + M-1);
                bfs();
            }
	    }
	    
	    System.out.print(answer);
	}
	static void bfs(){
	    int y, x, ny, nx, temp;
	    
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        
	        y = temp/M;
	        x = temp%M;
	        
	        if(visit[y][x]) continue;
	        visit[y][x] = true;
	        
            for(int i=0;i<6;i++){
                ny = y+dy[i];
                nx = x+dx[y%2][i];
                
                if(ny<0 || ny>=N || nx<0 || nx>=M || visit[ny][nx]) continue;
                else if(input[ny][nx]) {
                    answer++;
                    continue;
                }
                
                queue.offer(ny*M+nx);
            }
	    }
	}
}
