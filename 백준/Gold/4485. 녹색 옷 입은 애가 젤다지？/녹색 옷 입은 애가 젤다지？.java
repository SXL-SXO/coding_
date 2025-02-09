import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int input[][], count[][];
    static int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.cost-o2.cost);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int k=1;;k++){
		    N = Integer.parseInt(br.readLine());
		    if(N==0) break;
		    input = new int[N][N];
		    count = new int[N][N];
		    
		    for(int i=0;i<N;i++){
		        st = new StringTokenizer(br.readLine());
		        Arrays.fill(count[i], 100000);
		        for(int j=0;j<N;j++) input[i][j] = Integer.parseInt(st.nextToken());
		    }
		    
		    pq.offer(new Node(0,0,input[0][0]));
		    check();
		    
		    sb.append("Problem ").append(k).append(": ").append(count[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);
	}
	static void check(){
	    Node temp;
	    int ny, nx;
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        
	        for(int i=0;i<4;i++){
	            ny = temp.y + dy[i];
	            nx = temp.x + dx[i];
	            
	            if(ny<0 || ny>=N || nx<0 || nx>=N || count[ny][nx]<=input[ny][nx]+temp.cost) continue;
	            count[ny][nx] = input[ny][nx]+temp.cost;
	            pq.offer(new Node(ny, nx, input[ny][nx]+temp.cost));
	        }
	    }
	}
	static class Node{
	    int y, x, cost;
	    
	    Node(int y, int x, int cost){
	        this.y=y;
	        this.x=x;
	        this.cost=cost;
	    }
	}
}
