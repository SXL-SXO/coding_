import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.c-o2.c);
    static boolean visit[];
    static List<List<Node>> link = new ArrayList<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    visit = new boolean[N+1];
	    for(int i=0;i<=N;i++) link.add(new ArrayList<>());
	    int a, b, c;
	    for(int j=0;j<M;j++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        
	        if(a==b) continue;
	        
	        link.get(a).add(new Node(b, c));
	        link.get(b).add(new Node(a, c));
	    }
	    
	    pq.offer(new Node(1, 0));
	    Node temp;
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        if(visit[temp.idx]) continue;
	        visit[temp.idx] = true;
	        answer += temp.c;
	        
	        for(Node n : link.get(temp.idx)){
	            if(visit[n.idx]) continue;
	            pq.offer(n);
	        }
	    }
	    
	    
		System.out.println(answer);
	}
	static class Node{
	    int idx, c;
	    Node(int idx, int c){
	        this.idx = idx;
	        this.c = c;
	    }
	}
}
