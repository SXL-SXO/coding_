import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static PriorityQueue<Node> pq = new PriorityQueue<>(
        (o1, o2) -> o1.len==o2.len ? o1.sum==o2.sum ? o1.s.compareTo(o2.s): o1.sum-o2.sum : o1.len-o2.len 
    );
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<N;i++){
	        pq.offer(new Node(br.readLine()));
	    }
	    
	    for(int i=0;i<N;i++) sb.append(pq.poll().s).append("\n");
	    
		System.out.println(sb);
	}
	static class Node{
	    int len, sum;
	    String s;
	    Node(String s){
	        this.len = s.length();
	        this.s = s;
	        this.sum = cal(s.toCharArray());
	    }
	    
    	int cal(char c[]){
    	    int res = 0;
    	    for(char cc : c){
    	        if('0'<=cc && cc<='9') res += cc-'0';
    	    }
    	    return res;
    	}
	}
}
