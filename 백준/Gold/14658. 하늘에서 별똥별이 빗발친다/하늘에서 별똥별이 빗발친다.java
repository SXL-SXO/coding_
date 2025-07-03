import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, L, K, cover = 1;
    static Node input[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.y-o2.y);
    static Queue<Node> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new Node[K];
		for(int i=0;i<K;i++){
		    st = new StringTokenizer(br.readLine());
		    
		    input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(input, (o1, o2)-> o1.x==o2.x ? o1.y-o2.y : o1.x-o2.x);
		
	    int idx = 0;
	    Node start, n;
	    for(int i=0;i<K-1;i++){
	        pq.clear();
	        queue.clear();
	        
            pq.offer(input[i]);
	        for(idx = i+1;idx<K;idx++) {
	            if(input[i].x+L < input[idx].x) break;
	            pq.offer(input[idx]);
	        }
	        
	        start = pq.poll();
	        while(!pq.isEmpty()){
	            n = pq.poll();
	            
	            queue.offer(n);
	            while(start.y+L<n.y) start = queue.poll();
	            
	            cover = Math.max(cover, queue.size()+1);
	        }
	        
	    }
	    
	    System.out.print(K-cover);
		
	}
	static class Node{
	    int x, y;
	    Node(int x, int y){
	        this.x=x;
	        this.y=y;
	    }
	}
}
