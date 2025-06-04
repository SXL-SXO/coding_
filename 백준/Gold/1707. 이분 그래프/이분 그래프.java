import java.util.*;
import java.io.*;

public class Main
{
    static boolean answer;
	static int T, N, M;
	static int num[];
	static boolean visit[];
	static List<List<Integer>> list = new ArrayList<>(); // 같은 팀 하면 안되는 녀석들
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            list.clear();
            for(int i=0;i<=N;i++) list.add(new ArrayList<>());
            visit = new boolean[N+1];
            num = new int[N+1];
            answer = true;
            
            int A, B;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                
                list.get(A).add(B);
                list.get(B).add(A);
            }
            
            for(int i=1;i<=N;i++) if(answer && !visit[i]) go(i);
            
            // System.out.print(Arrays.toString(num));
            
            if(answer) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
	}
	static void go(int n){
	    queue.clear();
	    queue.offer(n);
	    
	    visit[n] = true;
	    num[n] = 2;
	    
	    int temp, size, count = 0;
	    while(!queue.isEmpty()){
	        size = queue.size();
	        
	        for(int s=0;s<size;s++){
    	        temp = queue.poll();
    	        
    	        for(int next : list.get(temp)){
    	            if(visit[next]){
    	                if(num[next] == (count+1)%2+1) {
    	                    answer = false;
    	                    return ;
    	                }
    	                continue;
    	            }
    	            visit[next] = true;
    	            num[next] = count%2+1;
    	            queue.offer(next);
    	        }
	        }
	        count++;
	    }
	}
}
