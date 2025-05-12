import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean visit[], check[];
    static Node answer[];
    static Queue<Integer> queue = new ArrayDeque<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.val==o1.val ? o1.idx-o2.idx : o2.val-o1.val);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<=N;i++) list.add(new ArrayList<>());
	    visit = new boolean[N+1];
	    
	    int a, b;
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        list.get(b).add(a);
	    }
	    
	    for(int i=1;i<=N;i++){
    	    pq.offer(new Node(i, bfs(i)));
	    }
	    
	    Node before = pq.poll();
	    while(!pq.isEmpty() && before.val == pq.peek().val){
	        sb.append(before.idx).append(" ");
	        before = pq.poll();
	    }
	    sb.append(before.idx);
	    
	    System.out.print(sb);
	}
	static class Node{
	    int idx, val;
	    Node(int idx, int val){
	        this.idx = idx;
	        this.val = val;
	    }
	}
	static int bfs(int idx){
	    int temp, res = 0;
	    
	    Arrays.fill(visit, false);
	    visit[idx] = true;
	    
	    queue.offer(idx);
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        res++;
	        for(int n : list.get(temp)){
	            if(visit[n]) continue;
	            visit[n] = true; 
	            queue.offer(n);
	        }
	    }
	    
	    return res;
	}
}
