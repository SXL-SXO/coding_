import java.util.*;
import java.io.*;

public class Main
{
    static boolean win = true, same = true;
    static int N, last;
    static char input[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder(), sang = new StringBuilder();
    static PriorityQueue<Node> pq = new PriorityQueue<>(
        (o1, o2)-> o1.c==o2.c ? o2.idx-o1.idx : o1.c-o2.c );
    public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    input = br.readLine().toCharArray();
	    visit = new boolean[N];
	    last = N-1;
	    
	    for(int i=0;i<N-1;i++){
	        pq.offer(new Node(input[i], i));
	    }
        visit[last] = true;
	    
	    Node temp;
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        if(visit[temp.idx]) continue;
	        visit[temp.idx] = true;
	        
	        sb.append(temp.c);
	        sang.append(input[last]);
	        
	        if(same) win = win && temp.c<=input[last];
	        same = same && temp.c==input[last];
	        
	        for(;last>=0;last--){
	            if(!visit[last]) {
	                visit[last] = true;
	                break;
	            }
	        }
	    }
	    
	    if(!win || sb.toString().equals(sang.toString())) sb.insert(0, "NE\n");
	    else sb.insert(0, "DA\n");
	    
	    System.out.print(sb);
    }
    static class Node{
        int idx;
        char c;
        Node(char c, int idx){
            this.c=c;
            this.idx=idx;
        }
    }
}
