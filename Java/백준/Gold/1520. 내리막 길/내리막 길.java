import java.io.*;
import java.util.*;

public class Main
{
    static int N, M;
    static int input[][], visit[][], count[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new int[N][M];
		visit = new int[N][M];
		count = new int[N][M];
		
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<M;j++){
		        input[i][j] = Integer.parseInt(st.nextToken());
		    }
		    visit[i][0] |= 1<<1;
		    visit[i][M-1] |= 1<<3;
		}
		
		for(int i=0;i<M;i++){
		    visit[0][i] |= 1<<2;
		    visit[N-1][i] |= 1<<0;
		}
		
		int ny, nx;
		for(int i=0;i<N;i++){
		    for(int j=0;j<M;j++){
		        for(int k=0;k<4;k++){
		            ny = i+dy[k];
		            nx = j+dx[k];
		            if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
		            else if(input[ny][nx]<=input[i][j]) {
		                visit[i][j] |= 1<<((k+2)%4);
		            }
		        }
		    }
		}
	    visit[0][0] = 15;
	    count[0][0] = 1;
		for(int i=0;i<N;i++){
		    for(int j=0;j<M;j++){
		        if(visit[i][j] == 15) {
		            queue.offer(i*M+j);
		        }
		    }
		}
		
		        
		dfs();
		
		System.out.println(count[N-1][M-1]);
	}
	static void dfs(){
	    int temp, y, x, ny, nx;
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        y = temp/M;
	        x = temp%M;
	        for(int i=0;i<4;i++){
	            ny = y + dy[i];
	            nx = x + dx[i];
	            
	            if(ny<0 || ny>=N || nx<0 || nx>=M || visit[ny][nx]==15) continue;
	            visit[ny][nx] |= 1<<i;
	            
	            if(input[y][x]>input[ny][nx]) count[ny][nx] += count[y][x];
	            if(visit[ny][nx]==15) queue.offer(ny*M+nx);
	        }
	    }
	}
}
