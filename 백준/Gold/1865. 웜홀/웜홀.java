import java.util.*;
import java.io.*;
public class Main
{
    static int T, N, M, W, max = 10_0000_0001;
    static boolean res;
    static Node[] edge;
    static int dis[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    
	    for(int t=0;t<T;t++){
	        st = new StringTokenizer(br.readLine());
	        
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        W = Integer.parseInt(st.nextToken());
	        
	        edge = new Node[M*2+W];
	        
	        dis = new int[N+1];
	        Arrays.fill(dis, max);
	        
	        res = false;
	        
	        int a, b, c;
	        for(int i=0;i<M;i++){
	            st  = new StringTokenizer(br.readLine());
	            
	            a = Integer.parseInt(st.nextToken());
	            b = Integer.parseInt(st.nextToken());
	            c = Integer.parseInt(st.nextToken());
	            
	            if(a==b) c = 0;
	            edge[i*2] = new Node(a, b, c);
	            edge[i*2+1] = new Node(b, a, c);
	            
	        }
	        for(int i=0;i<W;i++){
	            st = new StringTokenizer(br.readLine());
	            
	            a = Integer.parseInt(st.nextToken());
	            b = Integer.parseInt(st.nextToken());
	            c = Integer.parseInt(st.nextToken());
	            
	            if(a==b) res = true;
	            edge[M*2+i] = new Node(a, b, -c);
	        }
	        
	        for(int i=1;i<N;i++){
	            if(!res && dis[i]==max) res = bell(i);
	        }
	        if(res) sb.append("YES\n");
	        else sb.append("NO\n");
	    }
	    System.out.print(sb);
	}
	static boolean bell(int start){
	    dis[start] = 0;
	    
	    for(int i=0;i<N;i++){
	        for(Node n : edge){
	            if(dis[n.s] != max && dis[n.s]+n.c < dis[n.e]){
	                dis[n.e] = dis[n.s] + n.c;
	                if(i==N-1) return true;
	            }
	        }
	    }
	    return false;
	}
	static class Node{
	    int s, e, c;
	    Node(int s, int e, int c){
	        this.s=s;
	        this.e=e;
	        this.c=c;
	    }
	}
}
