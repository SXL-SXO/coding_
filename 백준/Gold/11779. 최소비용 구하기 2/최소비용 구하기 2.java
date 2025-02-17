import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, start, end;
    static List<List<Node>> list = new ArrayList<>();
    static int cost[];
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.c-o2.c);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    visit = new boolean[N+1];
	    cost = new int[N+1];
        Arrays.fill(cost, 100000001);
	    for(int i=0;i<=N;i++) {
	        list.add(new ArrayList<>());
	    }
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        list.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    start = Integer.parseInt(st.nextToken());
	    end = Integer.parseInt(st.nextToken());
	    
	    dijistra();
	    
	    System.out.print(sb);
	}
	static void dijistra(){
	    pq.offer(new Node(start, 0, new StringBuilder().append(start)));
	    
	    Node temp = new Node(-1, -1);
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        
	        if(visit[temp.v]) continue;
	        else if(temp.v==end) break;
	        visit[temp.v] = true;
	        
	        for(Node n : list.get(temp.v)){
	            if(temp.c+n.c > cost[n.v]) continue;
	            cost[n.v] = temp.c+n.c;
	            pq.offer(new Node(n.v, temp.c+n.c, new StringBuilder(temp.str).append(" ").append(n.v)));
	        }
	    }
	    
	    String str[] = temp.str.toString().split(" ");
	    sb.append(cost[end]).append("\n").append(str.length).append("\n").append(temp.str);
	}
	static class Node{
	    int v, c;
	    StringBuilder str;
	    Node(int v, int c){
	        this.v = v;
	        this.c = c;
	    }
	    Node(int v, int c, StringBuilder str){
	        this.v = v;
	        this.c = c;
	        this.str = str;
	    }
	}
}
