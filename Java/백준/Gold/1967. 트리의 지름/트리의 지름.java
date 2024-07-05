import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static boolean visit[];
    static int count[], par[], tree[];
    static List<List<Integer>> link = new ArrayList<>();
    static List<List<Integer>> level = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		count = new int[N+1];
		par = new int[N+1];
		tree = new int[N+1];
		
		for(int i=0;i<=N;i++){
		    link.add(new ArrayList<>());
		}
		
		int a, b, c;
		for(int i=0;i<N-1;i++){
		    st = new StringTokenizer(br.readLine());
		    a = Integer.parseInt(st.nextToken());
		    b = Integer.parseInt(st.nextToken());
		    c = Integer.parseInt(st.nextToken());
		    
		    tree[b] = c;
		    par[b] = a;
		    
		    link.get(a).add(b);
		}
		
		if(N==1){
		    System.out.print(0);
		    return;
		}
		
		
		int temp, size, lv = 0;
		
		
		queue.offer(1);
		while(!queue.isEmpty()){
		    size = queue.size();
		    level.add(new ArrayList<>());
		    for(int i=0;i<size;i++){
		        temp = queue.poll();
		        level.get(lv).add(temp);
		        for(int j : link.get(temp)){
		            queue.offer(j);
		        }
		    }
		    lv++;
		}
		
		lv-=1;
		for(int i=lv;i>=0;i--){
		    for(int j : level.get(i)){
    		    answer = Math.max(answer, count[par[j]]+tree[j]+count[j]);
    		    count[par[j]] = Math.max(count[par[j]],tree[j]+count[j]);
		    }
		}
		
		System.out.print(answer);
	}
}
