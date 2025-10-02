import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static List<List<Node>> list = new ArrayList<>();
    static long sum = 0, total = 0, answer = -1;
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->o1.c-o2.c);
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<=N;i++) list.add(new ArrayList<>());
	    visit = new boolean[N+1];
	    
	    int a, b, c;
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        
	        list.get(a).add(new Node(b, c));
	        list.get(b).add(new Node(a, c));
	        
	        sum += c;
	    }
	    
	    mst();
	    check();
	    
		System.out.println(answer);
	}
	static void check(){
	    for(int i=1;i<=N;i++) if(!visit[i]) return;
	    answer = sum-total;
	}
	static void mst(){
	    Node temp;
	    pq.offer(new Node(1, 0));
	    
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        if(visit[temp.idx]) continue;
	        visit[temp.idx] = true;
	        total += temp.c;
	        
	        for(Node n : list.get(temp.idx)){
	            if(!visit[n.idx]) pq.offer(n);
	        }
	    }
	}
	static class Node{
	    int idx, c;
	    Node(int idx, int c){
	        this.idx = idx;
	        this.c = c;
	    }
	}
}
