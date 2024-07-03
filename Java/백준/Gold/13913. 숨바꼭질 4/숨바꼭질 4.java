import java.util.*;
import java.io.*;
public class Main
{
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->(o1.t-o2.t));
    static int N, K;
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if(N>=K){
		    sb.append(N-K).append("\n");
		    for(int i=N;i>=K;i--){
		        sb.append(i).append(" ");
		    }
		    System.out.print(sb);
		    return;
		}
		
		visit = new boolean[K*2+1];
		
		queue.offer(new Node(0, N, ""+N));
		
		Node temp, answer;
		while(!queue.isEmpty()){
		    temp = queue.poll();
		    if(visit[temp.i]) continue;
		    visit[temp.i] = true;
		  //  System.out.print(temp.i+" "+temp.t+" / ");
		    if(temp.i == K){
		        sb.append(temp.t).append("\n").append(temp.ans);
		        break;
		    }
		    if(temp.i!=0 && temp.i<K && !visit[temp.i*2]){
                queue.offer(new Node(temp.t+1, temp.i*2, temp.ans+" "+(temp.i*2)));
		    }
            if(temp.i<K && !visit[temp.i+1]){
                queue.offer(new Node(temp.t+1, temp.i+1, temp.ans+" "+(temp.i+1)));
            }
            if(temp.i>0 && !visit[temp.i-1]){
                queue.offer(new Node(temp.t+1, temp.i-1, temp.ans+" "+(temp.i-1)));
            }
		}
		
		System.out.print(sb);
	}
	static class Node{
	    int t, i;
	    String ans;
	    Node(int t, int i, String ans){
	        this.t = t;
	        this.i = i;
	        this.ans = ans;
	    }
	    
	}
}
