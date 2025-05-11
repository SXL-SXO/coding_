import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer = 0;
    static Map<String, Integer> map = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.val==o2.val ? o1.idx-o2.idx : o1.val-o2.val);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	   
	    Node before;
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<M;j++) pq.offer(new Node(j, Integer.parseInt(st.nextToken())));
	        
	        before = pq.poll();
	        sb.append(before.idx).append(" ");
	        for(int j=1;j<M;j++) {
	            if(before.val == pq.peek().val) sb.append("|");
	            
	            before = pq.poll();
	            sb.append(before.idx).append(" ");
	        }
	        
	        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
	        sb.setLength(0);
	    }
	    
	    for(int s : map.values()){
	        answer += s*(s-1)/2 ;
	    }
		System.out.print(answer);
	}
	static class Node{
	    int idx, val;
	    Node(int idx, int val){
	        this.idx = idx;
	        this.val = val;
	    }
	}
	
	//정렬시 순서가 완전히 같으면 됨
}
