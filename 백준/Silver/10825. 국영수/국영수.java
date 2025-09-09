import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static PriorityQueue<Node> pq = new PriorityQueue<>
    ((o1, o2) -> o2.k==o1.k ? o2.e==o1.e ? o1.m==o2.m ? o1.n.compareTo(o2.n) : o2.m-o1.m : o1.e-o2.e : o2.k-o1.k);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        pq.offer(new Node(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
	    }
	    
	    for(int i=0;i<N;i++) sb.append(pq.poll().n).append("\n");
		System.out.println(sb);
	}
	static class Node{
	    String n;
	    int e, k, m;
	    Node(String n, int k, int e, int m){
	        this.n=n;
	        this.k=k;
	        this.e=e;
	        this.m=m;
	    }
	}
}
