import java.util.*;
import java.io.*;
public class Main
{
    static int N, Q;
    static Node input[];
    static int question[][];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)->(o1.e-o2.e));
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new Node[N];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	    }
	    Arrays.sort(input, (o1,o2)->o1.s-o2.s);
	    
	    Q = Integer.parseInt(br.readLine());
	    question = new int[Q][3];
        st = new StringTokenizer(br.readLine());
	    for(int i=0;i<Q;i++){
	        question[i][0] = i;
	        question[i][1] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(question, (o1, o2)->(o1[1]-o2[1]));
	    
	    int k = 0;
	    for(int j=0;j<Q;j++){
    	    for(;k<N;k++){
    	        if(question[j][1]<input[k].s) break;
    	        pq.offer(input[k]);
    	    }
    	    while(!pq.isEmpty()&&pq.peek().e<question[j][1]) pq.poll();
    	    question[j][2] = pq.size();
	    }
	    Arrays.sort(question, (o1, o2)->o1[0]-o2[0]);
	    
	    for(int i=0;i<Q;i++) sb.append(question[i][2]).append("\n");
	    
		System.out.println(sb);
	}
	static class Node{
	    int s, e;
	    Node(int s, int e){
	        this.s=s;
	        this.e=e;
	    }
	}
}
