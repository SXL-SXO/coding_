import java.util.*;
import java.io.*;

public class Main
{
    static double answer = 0;
    static int N, M;
    static Node input[];
    static int root[], size[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> o1.dis-o2.dis<0 ? -1 : 1);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new Node[N+1];
		root = new int[N+1];
		size = new int[N+1];
		
		for(int i=1;i<=N;i++){
		    st = new StringTokenizer(br.readLine());
		    input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		    root[i] = i;
		    size[i] = 1;
		}
		
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		cal();
		
		answer = Math.round(answer*100)/100.0;
		System.out.printf("%.2f",answer);
	}
	static void cal(){
		for(int i=1;i<N;i++){
		    for(int j=i+1;j<=N;j++){
		        if(root[i]==root[j]) continue;
		        pq.offer(new Node(i, j, cal_dis(input[i], input[j])));
		    }
		}
		
		Node temp;
		while(!pq.isEmpty()){
		    temp = pq.poll();
		    if(union(temp.y, temp.x)) answer += temp.dis;
		}
		
	}
	static double cal_dis(Node i, Node j){
	    return Math.sqrt(Math.pow(i.x-j.x, 2)+Math.pow(i.y-j.y, 2));
	}
	static int find(int a){
	    if(root[a]==a) return a;
	    return root[a] = find(root[a]);
	}
	static boolean union(int a, int b){
	    int ar = find(a);
	    int br = find(b);
	    
	    if(ar==br) return false;
	    
	    if(size[ar]<size[br]){
	        root[ar] = br;
	        size[br] += size[ar];
	    }else if(size[ar]>size[br]){
	        root[br] = ar;
	        size[ar] += size[br];
	    }else{
	        if(ar<br) {
    	        root[br] = ar;
    	        size[ar] += size[br];
    	    }
	        else {
    	        root[ar] = br;
    	        size[br] += size[ar];
    	    }
	    }
	    return true;
	}
	static class Node{
	    int y, x;
	    double dis;
	    Node(int y, int x){
	        this.y = y;
	        this.x = x;
	    }
	    Node(int x, int y, double dis){
	        this.y=y;
	        this.x=x;
	        this.dis=dis;
	    }
	}
}
