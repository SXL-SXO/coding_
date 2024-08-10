import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static char map[][];
    static int visit[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		visit = new int[N][N];
		for(int i=0;i<N;i++){
		    map[i] = br.readLine().toCharArray();
		    Arrays.fill(visit[i], N*N);
		}
		
		visit[0][0] = 0;
		bfs();
		System.out.println(visit[N-1][N-1]);
	}
	static void bfs(){
		
		queue.offer(0);
		
		int temp, y, x, ny, nx;
		while(!queue.isEmpty()){
		    temp = queue.poll();
		    y = temp/N;
		    x = temp%N;
		    for(int i=0;i<4;i++){
		        ny = y+dy[i];
		        nx = x+dx[i];
		        
		        if(ny>=N || ny<0 || nx>=N || nx<0) continue;
		        if(map[ny][nx]=='1' && visit[ny][nx]>visit[y][x]) {
		            visit[ny][nx] = visit[y][x];
		            queue.offer(ny*N+nx);
		        }else if(map[ny][nx]=='0' && visit[ny][nx]>visit[y][x]+1) {
		            visit[ny][nx] = visit[y][x]+1;
		            queue.offer(ny*N+nx);
		        }
		    }
		}
	    
	}
}
