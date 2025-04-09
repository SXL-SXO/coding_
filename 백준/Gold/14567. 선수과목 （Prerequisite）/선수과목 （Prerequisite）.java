import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static Node sub[];
    static int answer[];
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    sub = new Node[N];
	    answer = new int[N];
    	for(int i=0;i<N;i++) sub[i] = new Node();
	    
	    int A, B;
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        A = Integer.parseInt(st.nextToken())-1;
	        B = Integer.parseInt(st.nextToken())-1;
	        
	        sub[A].children.add(B);
	        sub[B].parent[A] = true;
	    }
	    
	    int count = 0, size, temp;
	    for(int i=0;i<N;i++) {
	        if(check(sub[i])) queue.offer(i);
	    }
	    while(!queue.isEmpty()){
	        count++;
	        size = queue.size();
	        for(int i=0;i<size;i++){
	            temp = queue.poll();
	            for(int c: sub[temp].children){
                    sub[c].parent[temp] = false;
                    if(check(sub[c])) queue.offer(c);
                }
                answer[temp] = count;
	        }
	    }
	    
	    for(int i=0;i<N;i++) sb.append(answer[i]).append(" ");
		System.out.println(sb);
	}
	static boolean check(Node n){
	    for(int i=0;i<N;i++){
	        if(n.parent[i]) return false;
	    }
	    return true;
	}
	static class Node{
	    boolean parent[];
	    List<Integer> children;
	    
	    Node(){
	        parent = new boolean[N];
	        children = new ArrayList<>();
	    }
	}
}
