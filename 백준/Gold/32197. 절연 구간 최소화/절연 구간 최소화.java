import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, S, E, answer;
    static boolean visit[][];
    static int cost[][];
    static List<List<Integer>> list_X = new ArrayList<>();
    static List<List<Integer>> list_Y = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.c-o2.c);
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    cost = new int[2][N+1];
	    visit = new boolean[2][N+1];
	    Arrays.fill(cost[0], 100001);
	    Arrays.fill(cost[1], 100001);
	    
	    for(int i=0;i<=N;i++) {
	        list_X.add(new ArrayList<>());
	        list_Y.add(new ArrayList<>());
	    }
	    
	    int a, b, c;
	    for(int i=0;i<M;i++) {
	        st = new StringTokenizer(br.readLine());
	        
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        
	        if(c==0){
	            list_X.get(a).add(b);
	            list_X.get(b).add(a);
	        }else{
	            list_Y.get(a).add(b);
	            list_Y.get(b).add(a);
	        }
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    
	    S = Integer.parseInt(st.nextToken());
	    E = Integer.parseInt(st.nextToken());
	    
	    visit[0][S] = true;
        cost[0][S] = 0;
	    for(int i : list_X.get(S)) {
	        cost[0][i] = 0;
	        pq.offer(new Node(i, 0, 0));
	    }
	    visit[1][S] = true;
	    cost[1][S] = 0;
	    for(int i : list_Y.get(S)) {
	        cost[1][i] = 0;
	        pq.offer(new Node(i, 0, 1));
	    }
	    
		go();
		
		answer = Math.min(cost[0][E], cost[1][E]);
		System.out.print(answer);
	}
	static void go(){
	    Node temp;
	    
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	       // System.out.println(temp.w+" "+temp.c+" "+temp.t);
	        
	        if(temp.w == E) break; 
	        else if(visit[temp.t][temp.w]) continue;
	        visit[temp.t][temp.w] = true;
	        
	        if(temp.t == 0){
	            for(int i : list_X.get(temp.w)) {
	                if(!visit[0][i] && temp.c < cost[0][i]) {
	                    cost[0][i] = temp.c;
	                    pq.offer(new Node(i, temp.c, 0)); 
	                }
	            }
                for(int i : list_Y.get(temp.w)) {
	                if(!visit[1][i] && temp.c+1 < cost[1][i]) {
	                    cost[1][i] = temp.c+1;
	                    pq.offer(new Node(i, temp.c+1, 1)); 
	                }
                }
                
	        }else{
	            for(int i : list_Y.get(temp.w)) {
	                if(!visit[1][i] && temp.c < cost[1][i]) {
	                    cost[1][i] = temp.c;
	                    pq.offer(new Node(i, temp.c, 1)); 
	                }
	            }
                for(int i : list_X.get(temp.w)) {
	                if(!visit[0][i] && temp.c+1 < cost[0][i]) {
	                    cost[0][i] = temp.c+1;
	                    pq.offer(new Node(i, temp.c+1, 0)); 
	                }
                }
	        }
	    }
	    
	}
	static class Node{
	    int w, c, t;
	    Node(int w, int c, int t){
	        this.w=w;
	        this.c=c;
	        this.t=t;
	    }
	}
}
