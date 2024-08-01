import java.util.*;
import java.io.*;

public class Main
{
    static int N = 12, M = 6, answer = 0;
    static char map[][];
    static boolean visit[][] = new boolean[12][6];;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean status;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    map = new char[N][];
	    for(int i=0;i<N;i++){
	        map[i] = br.readLine().toCharArray();
	    }
	    
	    check();
	    
	    System.out.print(answer);
	}
	static void check(){
	    status = false;
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            if(map[i][j]=='.'||visit[i][j]) continue;
	            
	            status |= bfs(i, j, map[i][j]);
	        }
	    }
	    
	    if(!status) return; 
	    
	    answer++;
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            if(!visit[i][j]) continue;
	            visit[i][j] = false;
	            map[i][j] = '.';
	        }
	    }
	   
	    gravity();
	    check();
	}
	
	static boolean bfs(int a, int b, char c){
	    int y, x, ny, nx, temp, count = 0;
	    
	    visit[a][b] = true;
        queue.offer(a*M+b);
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        count++;
	        y = temp/M;
	        x = temp%M;
	        for(int i=0;i<4;i++){
	            ny = y + dy[i];
	            nx = x + dx[i];
	            if(ny>=N || ny<0 || nx>=M || nx<0 || visit[ny][nx] || map[ny][nx]!=c) continue;
	            visit[ny][nx] = true;
	            queue.offer(ny*M+nx);
 	        }
	    }
	    
        // System.out.println(a+" "+b +" "+c+" "+count);
	    if(count>=4) return true;
	    
	    visit[a][b] = false;
        queue.offer(a*M+b);
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        y = temp/M;
	        x = temp%M;
	        
	        for(int i=0;i<4;i++){
	            ny = y + dy[i];
	            nx = x + dx[i];
	            if(ny>=N || ny<0 || nx>=M || nx<0 || !visit[ny][nx] || map[ny][nx]!=c) continue;
                visit[ny][nx] = false;
                queue.offer(ny*M+nx);
 	        }
	    }
	    return false;
	}
	static void gravity(){
	    for(int i=N-1;i>=0;i--){
	        for(int j=0;j<M;j++){
	            if(map[i][j]!='.'){
	                int k = i+1;
	                for(;k<N;k++){
	                    if(map[k][j]!='.') break;
	                }
	                if(i+1==k) continue;
	                map[k-1][j] = map[i][j];
	                map[i][j] = '.';
	            }
	        }
	    }
	}
}
