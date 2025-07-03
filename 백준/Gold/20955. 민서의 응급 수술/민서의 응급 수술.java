import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, answer = -1;
    static boolean visit[];
    static Queue<Integer> queue = new ArrayDeque<>();
    static List<List<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N+1];
		for(int i=0;i<=N;i++) list.add(new ArrayList<>());
		
		int a, b;
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		    
		    a = Integer.parseInt(st.nextToken());
		    b = Integer.parseInt(st.nextToken());
		    
		    list.get(a).add(b);
		    list.get(b).add(a);
		}
		
		for(int i=1;i<=N;i++){
		    if(visit[i]) continue;
		    
		    answer++;
		    link(i);
		}
		
		System.out.print(answer);
	}
	static void link(int idx){
	    queue.offer(idx);
	    visit[idx] = true;
	    
	    
	    int temp, count = 0, line = 0;
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        
	        count++;
	        line += list.get(temp).size();
	        
	        for(int n : list.get(temp)){
	            if(visit[n]) continue;
	            visit[n] = true;
	            
	            queue.offer(n);
	        }
	    }
	    line /= 2;
	    
	    if(line > count-1) answer += line - count + 1;
	    
	    return;
	}
}
