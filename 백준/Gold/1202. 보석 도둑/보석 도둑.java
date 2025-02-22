import java.util.*;
import java.io.*;
public class Main
{
    static int N, K;
    static long answer = 0;
    static int bag[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->o1.m-o2.m);
    static PriorityQueue<Node> jewel = new PriorityQueue<>((o1,o2)->o2.v-o1.v);
    public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    
	    bag = new int[K];
	    for(int i=0;i<K;i++) bag[i] = Integer.parseInt(br.readLine());
	    Arrays.sort(bag);
	    
	    Node temp; int idx = 0;
	    while(!pq.isEmpty() && idx<K){
	        temp = pq.poll();
	       
	        if(temp.m<bag[idx]) jewel.offer(temp);
	        else if(temp.m>bag[idx]) {
	            pq.offer(temp);
	            
	            idx++;
	            if(!jewel.isEmpty()) answer+=(long)jewel.poll().v;
	        }else{
	            jewel.offer(temp);
	            
	            idx++;
	            answer+=(long)jewel.poll().v;
	        }
	    }
	    
	    if(pq.isEmpty()) {
	        for(;idx<K;idx++){
	            if(jewel.isEmpty()) break;
	            answer+=(long)jewel.poll().v;
	        }
	    }
	    System.out.print(answer);
	}
	static class Node{
	    int m, v;
	    Node(int m, int v){
	        this.v=v;
	        this.m=m;
	    }
	}
}
