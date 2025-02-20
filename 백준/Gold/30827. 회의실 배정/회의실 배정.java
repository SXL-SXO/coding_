import java.util.*;
import java.io.*;

public class Main
{
    static int N, K, answer;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.e-o2.e );
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    answer = K = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
    	
    	if(N>K){ 
        	Node temp, check;
        	int idx = 0;
        	
        	Node time[] = new Node[K];
        	time[idx++] = pq.poll();
        	
        	while(!pq.isEmpty()){
        	    temp = pq.poll();
        	    check = new Node(-1, -1, 100000001);
        	    
        	    for(int i=0;i<idx;i++){
            	    if(time[i].e<temp.s && temp.s-time[i].e<check.diff) {
            	        check.e = temp.e;
            	        check.diff = temp.s-time[i].e;
            	        check.idx = i;
            	    }
        	    }
        	    
        	    if(check.idx==-1) {
        	        if(idx < K) time[idx++] = temp;
        	        continue;
        	    }
        	    
        	    time[check.idx].e = check.e;
        	    answer++;
        	}
    	}
    	System.out.print(answer);
	}
	static class Node{
	    int s, e, t, idx, diff;
	    Node(int s, int e){
	        this.s=s;
	        this.e=e;
	        t = e-s;
	    }
	    Node(int e, int idx, int diff){
	        this.e = e;
	        this.idx = idx;
	        this.diff = diff;
	    }
	}
}
