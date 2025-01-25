import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Node> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++){
		    queue.offer(new Node(i+1, Integer.parseInt(st.nextToken())));
		}
		
		Node temp = queue.poll();
		
		while(!queue.isEmpty()){
		    sb.append(temp.idx).append(" ");
		    if(temp.val>0){
		        for(int i=0;i<temp.val-1;i++) {
		            queue.offer(queue.poll());
		        }
		        temp = queue.poll();
		    }
		    
		    else{
		        for(int i=0;i>temp.val+1;i--){
		            queue.addFirst(queue.pollLast());
		        }
		        temp = queue.pollLast();
		    }
		}
		sb.append(temp.idx);
		System.out.print(sb);
	}
	static class Node{
	    int idx, val;
	    Node(int idx, int val){
	        this.idx=idx;
	        this.val=val;
	    }
	}
}
