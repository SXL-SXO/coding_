import java.util.*;
import java.io.*;

public class Main
{
	static Node input[];
	static int dp_weight[];
	static int N, M, answer = -1;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.v == o2.v ? o2.w-o1.w : o1.v-o2.v);
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.offer(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
        
        dp_weight = new int[N+1];
        
        input = new Node[N+1];
        input[0] = new Node(0,0);
        
        int count = 1;
        for(int i=1;i<=N;i++){
            input[i] = pq.poll();
            
            dp_weight[i] = dp_weight[i-1] + input[i].w;
            
            if(input[i].v == input[i-1].v) count++;
            else count = 1;
            
            if(dp_weight[i]>=M){
                answer = answer == -1 ? count*input[i].v : Math.min(answer, count*input[i].v);
            }
            
        }
        System.out.print(answer);
	}
	static class Node{
	    int w, v;
	    Node(int w, int v){
	        this.w =w;
	        this.v =v;
	    }
	}
}