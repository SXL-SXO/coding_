import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<>(
        (o1, o2) -> o1.s==o2.s ? o2.e-o1.e : o1.s-o2.s );
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    
	    Node b = pq.poll(), temp;
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        
	        if(temp.s<=b.e) b.e = Math.max(b.e, temp.e);
	        else {
	            answer += b.e-b.s;
	            b = temp;
	        }
	    }
	    answer += b.e-b.s;
	    
	    System.out.print(answer);
	}
	static class Node{
	    int s, e;
	    Node(int s, int e){
	        this.s=s;
	        this.e=e;
	    }
	}
}
