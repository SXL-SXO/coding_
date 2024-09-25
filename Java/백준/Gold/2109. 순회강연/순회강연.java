import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static PriorityQueue<Integer> value = new PriorityQueue<>((o1,o2) -> o2-o1);
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o2.d==o1.d ? o2.p-o1.p : o2.d-o1.d );
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		if(N == 0 ){
		    System.out.print(0);
		    return;
		}
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Node temp = pq.poll(), before;
		answer = 0;
		value.offer(temp.p);
		while(!pq.isEmpty()){
		    before = temp;
		    temp = pq.poll();
		    for(int i=0;i<before.d-temp.d;i++){
		        if(value.isEmpty()) break;
		      //  System.out.print(value.peek()+" ");
		        answer += value.poll();
		    }
		    value.offer(temp.p);
		}
		for(int i=0;i<temp.d;i++){
		    if(value.isEmpty()) break;
	       // System.out.print(value.peek()+" ");
	        answer += value.poll();
		}
		System.out.print(answer);
	}
	static class Node{
	    int d, p;
	    Node(int p, int d){
	        this.d = d;
	        this.p = p;
	    }
	}
}
