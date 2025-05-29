import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int answer[][];
    static char input[][];
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new char[N][];
	    answer = new int[N][M];
	    
	    for(int i=0;i<N;i++) {
	        input[i] = br.readLine().toCharArray();
	        Arrays.fill(answer[i], -1);
	        for(int j=0;j<M;j++){
	            if(input[i][j] == 'c') {
	                answer[i][j] = 0;
	                queue.offer(i*M+j);
	            }
	        }
	    }
	    
	    bfs();
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            sb.append(answer[i][j]).append(" ");
	        }
	        sb.append("\n");
	    }
		System.out.println(sb);
	}
	static void bfs(){
	    int ny, nx, temp, size, count = 0;
	    
	    while(!queue.isEmpty()){
	        count++;
	        size = queue.size();
	        for(int i=0;i<size;i++){
	            temp = queue.poll();
	            ny = temp/M;
	            nx = temp%M+1;
	            
	            if(nx>=M || answer[ny][nx] >=0) continue;
	            answer[ny][nx] = count;
	            queue.offer(ny*M+nx);
	        }
	    }
	}
}
