import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, K;
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean visit[], team[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<=N;i++) list.add(new ArrayList<>());
	    for(int i=1;i<=N;i++) {
	        st = new StringTokenizer(br.readLine());
	        M = Integer.parseInt(st.nextToken());
	        for(int j=0;j<M;j++) {
	            K = Integer.parseInt(st.nextToken());
	            list.get(i).add(K);
	            list.get(K).add(i);
	        }
	    }
	    visit = new boolean[N+1];
	    team = new boolean[N+1];
	    
	    for(int i=1;i<=N;i++) if(list.get(i).size()>0 && !visit[i]) dfs(i);
	    
	    
	    int count = 0;
	    for(int i=1;i<=N;i++) if(team[i]) count++;
	    
	    if(count == 0 || count == N){
	        sb.append("1\n1").append(N-1).append("\n");
	        for(int i=2;i<=N;i++) sb.append(i).append(" ");
	    }else{
	        sb.append(count).append("\n");
	        for(int i=1;i<=N;i++) if(team[i]) sb.append(i).append(" ");
	        sb.append("\n").append(N-count).append("\n");
	        for(int i=1;i<=N;i++) if(!team[i]) sb.append(i).append(" ");
	    }
	    
		System.out.println(sb);
	}
	static void dfs(int idx){
	    visit[idx] = true;
	    team[idx] = true;
	    queue.offer(idx);
	   // System.out.println(idx);
	    int temp, size, switchnum = 1;
	    while(!queue.isEmpty()){
	        size = queue.size();
	        for(int j=0;j<size;j++){
    	        temp = queue.poll();
    	        
    	        for(int i : list.get(temp)) {
    	            if(visit[i]) continue;
    	            visit[i] = true;
	                team[i] = switchnum%2 == 0;
	               // System.out.print(i+" "+team[i]+"|");
    	            queue.offer(i);
    	        }
	        }
	        switchnum++;
	    }
	    
	   // System.out.println(Arrays.toString(visit));
	   // System.out.println(Arrays.toString(team));
	}
}
