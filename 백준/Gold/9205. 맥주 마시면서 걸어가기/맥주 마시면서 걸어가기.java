import java.util.*;
import java.io.*;
public class Main
{
    static int T, N;
    static int start[] = new int[2], end[] = new int[2];
    static int input[][];
    static boolean visit[];
    static Queue<Node> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        
	        N = Integer.parseInt(br.readLine());
	        input = new int[N][2];
	        visit = new boolean[N];
	        
            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
	        
	        for(int i=0;i<N;i++){
	            st = new StringTokenizer(br.readLine());
	            input[i][0] = Integer.parseInt(st.nextToken());
	            input[i][1] = Integer.parseInt(st.nextToken());
	        }
	        
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
	        
	        bfs();
	    }
	    
	    System.out.print(sb);
	}
	static void bfs(){
	    queue.clear();
	    queue.offer(new Node(start[0], start[1]));
	    
	    Node temp;
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        
	        if(20*50>=Math.abs(temp.y-end[0])+Math.abs(temp.x-end[1])){
	            sb.append("happy\n");
	            return;
	        }
	        
	        for(int i=0;i<N;i++){
	            if(visit[i] || 20*50<(Math.abs(temp.y-input[i][0])+Math.abs(temp.x-input[i][1]))) continue;
	            visit[i] = true;
	            queue.offer(new Node(input[i][0], input[i][1]));
	        }
	    }
	    
	    sb.append("sad\n");
	}
	static class Node{
	    int y, x;
	    Node(int y, int x){
	        this.y=y;
	        this.x=x;
	    }
	}
}
