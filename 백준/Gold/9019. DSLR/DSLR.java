import java.util.*;
import java.io.*;

public class Main
{
    static int N, x, y;
    static StringBuilder sb = new StringBuilder();
    static Queue<Node> queue = new ArrayDeque<>();
    static boolean num[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        
	        num = new boolean[10000];
	        
	        x = Integer.parseInt(st.nextToken());
	        y = Integer.parseInt(st.nextToken());
	        
	        check();
	    }
	    System.out.print(sb);
	}
	static void check(){
	    queue.clear();
	    queue.offer(new Node("", x));
	    
	    Node temp;
	    int a, b, c, d;
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        
	        a = temp.next*2;
	        b = temp.next-1;
	        c = temp.next%1000*10 + temp.next/1000;
	        d = temp.next%10*1000 + temp.next/10;
	        
	        a = a>9999 ? a%10000 : a;
	        b = b<0 ? 9999 : b;
	        
	        if(a==y) {
	            sb.append(temp.s).append("D\n");
	            return;
	        }else if(b==y) {
	            sb.append(temp.s).append("S\n");
	            return;
	        }else if(c==y) {
	            sb.append(temp.s).append("L\n");
	            return;
	        }else if(d==y) {
	            sb.append(temp.s).append("R\n");
	            return;
	        }
	        
	        if(!num[a]){
	            num[a] = true;
	            queue.offer(new Node(temp.s+"D" ,a));
	        }
	        if(!num[b]){
	            num[b] = true;
	            queue.offer(new Node(temp.s+"S" ,b));
	        }
	        if(!num[c]){
	            num[c] = true;
	            queue.offer(new Node(temp.s+"L" ,c));
	        }
	        if(!num[d]){
	            num[d] = true;
	            queue.offer(new Node(temp.s+"R" ,d));
	        }
	        
	    }
	}
	static class Node{
	    String s;
	    int next;
	    Node(String s, int next){
	        this.s = s;
	        this.next = next;
	    }
	}
}
