import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer = 0;
    static char input[][];
    static boolean visit[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());

        input = new char[N][];
        visit = new boolean[N][M];
        
        for(int i=0;i<N;i++) input[i] = br.readLine().toCharArray();
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) if(input[i][j] == 'L') bfs(i*M+j);
        }
        	    
		System.out.println(answer);
	}
	static void bfs(int val){
	    queue.clear();
	    queue.offer(val);
	    
	    for(int i=0;i<N;i++) Arrays.fill(visit[i], false);
	    visit[val/M][val%M] = true;
	    
	    
	    int count = -1, size, temp, ny, nx;
	    while(!queue.isEmpty()){
	        count++;
	        size = queue.size();
	        
	        for(int i=0;i<size;i++){
	            temp = queue.poll();
	            
	            for(int j=0;j<4;j++){
	                ny = temp/M + dy[j];
	                nx = temp%M + dx[j];
	                
	                if(ny<0 || ny>=N || nx<0 || nx>=M || visit[ny][nx] || input[ny][nx] == 'W') continue;
	                
	                visit[ny][nx] = true;
	                queue.offer(ny*M+nx);
	            }
	        }
	    }
	    
	    answer = Math.max(answer, count);
	}
}
