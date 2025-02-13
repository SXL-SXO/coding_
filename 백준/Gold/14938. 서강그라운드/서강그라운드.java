import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, R, answer = 0;
    static List<List<Node>> link = new ArrayList<>();
    static int item[], dis[][];
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.c-o2.c);
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    item = new int[N+1];
	    visit = new boolean[N+1];
	    dis = new int[N+1][N+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=N;i++) item[i] = Integer.parseInt(st.nextToken()); 
	    
	    for(int i=0;i<=N;i++) {
	        link.add(new ArrayList<>());
	        Arrays.fill(dis[i], 5000);
	        dis[i][i] = 0;
	    }
	    
	    int a,b,c;
	    for(int i=0;i<R;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        
	        link.get(a).add(new Node(b, c));
	        link.get(b).add(new Node(a, c));
	    }
	    
	    for(int i=1;i<=N;i++){
	        dijistra(i);
	        answer = Math.max(answer, check(i));
	    }
	    
		System.out.println(answer);
	}
	static int check(int start){
	    int count = 0;
	    for(int i=1;i<=N;i++) if(dis[start][i]<=M) count+=item[i];
	    
	    return count;
	}
	static void dijistra(int start){
	    Arrays.fill(visit, false);
	    
	    pq.offer(new Node(start, 0));
	    
	    Node temp;
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        
	        if(visit[temp.v]) continue;
	        visit[temp.v] = true;
	        
	        for(Node n : link.get(temp.v)){
	            if(n.c+temp.c < dis[start][n.v]) {
	                dis[start][n.v] = n.c + temp.c;
	                pq.offer(new Node(n.v, n.c+temp.c));
	            }
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
