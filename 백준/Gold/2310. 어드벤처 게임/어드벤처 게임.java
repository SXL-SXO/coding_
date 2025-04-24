import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int room[], value[], have[];
    static List<List<Integer>> link = new ArrayList<>();
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o2.cost-o1.cost);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    while(true){
	        N = Integer.parseInt(br.readLine());
	        if(N==0) break;
	        
	        
	        start();
            for(int i=1;i<=N;i++) {
                st = new StringTokenizer(br.readLine());
                room[i] = st.nextToken().charAt(0);
                value[i] = Integer.parseInt(st.nextToken());
    	            
    	        int temp = Integer.parseInt(st.nextToken());
    	        while(temp!=0){
    	            link.get(i).add(temp);
    	            temp = Integer.parseInt(st.nextToken());
    	        }
            }
            
	        if(move()) sb.append("Yes\n");
	        else sb.append("No\n");
	    }
	    
	    
		System.out.println(sb);
	}
	static boolean move(){
	    Node temp;
	    
	    queue.offer(new Node(1, 0));
	    while(!queue.isEmpty()){
            temp = queue.poll();
            // System.out.println(temp.idx+" "+temp.cost);
            if(temp.idx == N) return true;
            if(have[temp.idx] >= temp.cost) continue;
            have[temp.idx] = temp.cost;
            
            for(int next : link.get(temp.idx)){
                if(temp.cost<=have[next]) continue;
                else if(room[next] == 'E') queue.offer(new Node(next, temp.cost));
                else if(room[next] == 'L') {
                    if(temp.cost<value[next]) queue.offer(new Node(next, value[next]));
                    else queue.offer(new Node(next, temp.cost));
                }else if(temp.cost-value[next]>have[next]) queue.offer(new Node(next, temp.cost-value[next]));
            }
	    }
	    return false;
	}
	static void start(){
	    room = new int[N+1];
        value = new int[N+1];
        have = new int[N+1];
        Arrays.fill(have, -1);
        
        link.clear();
        for(int i=0;i<=N;i++) link.add(new ArrayList<>());
        
        queue.clear();
	}
	static class Node{
	    int idx, cost;
	    Node(int idx, int cost){
	        this.idx = idx;
	        this.cost = cost;
	    }
	}
}
