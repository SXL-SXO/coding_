import java.util.*;
import java.io.*;

public class Main
{
    static int F, S, G, U, D;
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    F = Integer.parseInt(st.nextToken());
	    S = Integer.parseInt(st.nextToken());
	    G = Integer.parseInt(st.nextToken());
	    U = Integer.parseInt(st.nextToken());
	    D = Integer.parseInt(st.nextToken());
	    
	    visit = new boolean[F+1];
	    
	    bfs();
	    
		System.out.println(sb);
	}
	static void bfs(){
	    int temp, size, count = 0;
	    queue.offer(S);
	    visit[S] = true;
	    
	    while(!queue.isEmpty()){
	        size = queue.size();
	        for(int s=0;s<size;s++){
	            temp = queue.poll();
	            if(temp == G) {
	                sb.append(count);
	                return;
	            }
	            
	            if(temp+U<=F && !visit[temp+U]) {
	                visit[temp+U] = true;
	                queue.offer(temp+U);
	            }
	            if(temp-D>0 && !visit[temp-D]){
	                visit[temp-D] = true;
	                queue.offer(temp-D);
	            }
	        }
	        count++;
	    }
	    sb.append("use the stairs");
	}
}
