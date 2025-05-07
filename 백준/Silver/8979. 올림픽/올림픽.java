import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, answer = 1;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->
        o2.g==o1.g ? o2.s==o1.s ? o2.b==o1.b ? o2.idx-o1.idx : o2.b-o1.b : o2.s-o1.s : o2.g-o1.g );
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    
	    Node n = pq.poll(), before;
	    if(n.idx!=M) {
	        answer++;
	        
    	    int count = 0;
    	    for(;answer<=N; answer++){
    	        before = n;
    	        n = pq.poll();
    	        
    	        if(before.same(n)) count++;
    	        else count = 0;
    	        
    	        if(n.idx==M) {
    	            answer -= count;
    	            break;
    	        }
    	    }
	    }
	    System.out.print(answer);
	}
	
	static class Node{
	    int idx, g, s, b;
	    Node(int idx, int g, int s, int b){
	        this.idx = idx;
	        this.g = g;
	        this.s = s;
	        this.b = b;
	    }
	    
	    public boolean same(Node n){
	        return n.g == this.g && n.s == this.s && n.b == this.b;
	    }
	}
}