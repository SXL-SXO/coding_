import java.util.*;
import java.io.*;

public class Main
{
	static int N, M;
	static int cost[][];
	static List<List<Node>> link = new ArrayList<>();
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.c-o2.c);
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        cost = new int[N+1][N+1];
        
        for(int i=0;i<=N;i++){
            link.add(new ArrayList<>());
        }
        
        int a, b, c;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            
            link.get(a).add(new Node(b,c));
            // cost[a][b] = c;
        }
        
        for(int i=1;i<=N;i++){
            dijistra(i);
        }
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(cost[i][j] == 100_000_001) sb.append("0 ");
                else sb.append(cost[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}
	static void dijistra(int idx){
	    visit = new boolean[N+1];
	    Arrays.fill(cost[idx], 100_000_001);
        pq.offer(new Node(idx, 0));
        
        Node temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(visit[temp.v]) continue;
            visit[temp.v] = true;
            cost[idx][temp.v] = temp.c;
            for(Node n : link.get(temp.v)){
                if(!visit[n.v] && cost[idx][n.v]>n.c+temp.c) 
                    pq.offer(new Node(n.v, n.c+temp.c));
            }
        }
	    
	}
	static class Node{
	    int v, c;
	    Node(int v, int c){
	        this.v=v;
	        this.c=c;
	    }
	}
}
