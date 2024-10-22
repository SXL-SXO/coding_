import java.io.*;
import java.util.*;

public class Main
{
    static int T, N, M, W;
    static int time[], count[], dp[];
    static boolean visit[];
    static List<List<Integer>> link = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
		    
		    st = new StringTokenizer(br.readLine());
		    N = Integer.parseInt(st.nextToken());
		    M = Integer.parseInt(st.nextToken());
		    
		    time = new int[N+1];
		    count = new int[N+1];
		    dp = new int[N+1];
		    visit = new boolean[N+1];
	        st = new StringTokenizer(br.readLine());
	        
		    link.clear();
		    link.add(new ArrayList<>());
		    for(int i=1;i<=N;i++){
		        time[i] = Integer.parseInt(st.nextToken());
		        link.add(new ArrayList<>());
		    }
		    
		    int a, b;
		    for(int j=0;j<M;j++){
		        st = new StringTokenizer(br.readLine());
		        a = Integer.parseInt(st.nextToken());
		        b = Integer.parseInt(st.nextToken());
		        
		        count[a]++;
		        link.get(b).add(a);
		    }
		    
		    W = Integer.parseInt(br.readLine());
		    sb.append(check(W)).append("\n");
		}
		System.out.print(sb);
	}
	static int check(int W){
        if(link.get(W).isEmpty()) return time[W];
        
        queue.clear();
        for(int i=1;i<=N;i++){
            if(count[i]==0) queue.offer(i);
        }
        
	    int temp, size, bigger, answer = 0;
	    
	    dp[W] = time[W];
	    visit[W] = true;
	    while(!queue.isEmpty()){
	        size = queue.size();
	        for(int i=0;i<size;i++){
	            temp = queue.poll();
	            answer = Math.max(answer, dp[temp]);
	            for(int next : link.get(temp)){
	                if(visit[temp]) {
	                    dp[next] = Math.max(dp[next], dp[temp]+time[next]);
	                    visit[next] = true;
	                }
	                if(--count[next]==0) queue.offer(next);
	            }
	        }
	    }
	    return answer;
	}
}
