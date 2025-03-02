import java.util.*;
import java.io.*;
public class Main
{
    static int N, Q;
    static List<List<Node>> link = new ArrayList<>();
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.c-o2.c);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	   
	    N = Integer.parseInt(st.nextToken());
	    Q = Integer.parseInt(st.nextToken());
	    
	    visit = new boolean[N+1];
	    
	    for(int i=0;i<=N;i++) {
	        link.add(new ArrayList<>());
	    }
	    
	    int a, b, c;
	    for(int i=0;i<N-1;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        
	        link.get(a).add(new Node(b, c));
	        link.get(b).add(new Node(a, c));
	    }
	    
	    for(int i=0;i<Q;i++){
	        st = new StringTokenizer(br.readLine());
	        sb.append(check(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())))
	        .append("\n");
	    }
	    
	    System.out.print(sb);
	}
	static int check(int K, int V){
	    Node temp;
	    int count = 0;
	    
	    Arrays.fill(visit, false);
	    visit[V] = true;
	    
	    pq.clear();
	    for(Node n : link.get(V)) pq.offer(n);
	    
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        
	        if(temp.c<K || visit[temp.v]) continue;
	        visit[temp.v] = true;
	        count++;
	        
	        for(Node n : link.get(temp.v)) pq.offer(n);
	    }
	    return count;
	}
	static class Node{
	    int v, c;
	    Node(int v, int c){
	        this.v=v;
	        this.c=c;
	    }
	}
}
