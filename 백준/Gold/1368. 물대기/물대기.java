import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static int road[][];
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.c-o2.c);
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    road = new int[N][N];
	    visit = new boolean[N];
	    
	    for(int i=0;i<N;i++) pq.offer(new Node(i, Integer.parseInt(br.readLine())));
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<N;j++){
	            road[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    MST();
	    
	    System.out.print(answer);
	}
	static void MST(){
	    Node temp;
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        
	        if(visit[temp.v]) continue;
	        visit[temp.v] = true;
	        answer+=temp.c;
	        
	        for(int i=0;i<N;i++){
	            if(visit[i]) continue;
	            pq.offer(new Node(i, road[temp.v][i]));
	        }
	    }
	}
	static class Node{
	    int v, c;
	    Node(int v, int c){
	        this.v=v;
	        this.c=c;
	    }
	}
}
