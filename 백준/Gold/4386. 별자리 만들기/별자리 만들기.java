import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static double answer = 0;
    static double input[][];
    static boolean visit[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dis-o2.dis<0 ? -1 : 1);
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new double[N][2];
	    visit = new boolean[N];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i][0] = Double.parseDouble(st.nextToken());
	        input[i][1] = Double.parseDouble(st.nextToken());
	    }
	    mst();
	    
	    System.out.print(Math.round(answer*100)/100.0);
	}
	static void mst(){
	    Node temp;
	    
	    pq.offer(new Node(0, 0));
	    
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	        
	        if(visit[temp.idx]) continue;
	        answer += temp.dis;
	       // System.out.println(answer);
	        visit[temp.idx] = true;
	        
	        for(int i=0;i<N;i++){
	            if(i==temp.idx || visit[i]) continue;
	            pq.offer(new Node(i, cal(input[temp.idx], input[i])));
	        }
	    }
	}
	static double cal(double a[], double b[]){
	    return Math.sqrt((a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]));
	}
	static class Node{
	    int idx;
	    double dis;
	    Node(int idx, double dis){
	        this.idx = idx;
	        this.dis = dis;
	    }
	}
}
