import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer;
    static boolean visit[];
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<=N;i++) list.add(new ArrayList<>());
	    visit = new boolean[N+1];
	    
	    int a, b;
	    st = new StringTokenizer(br.readLine());
	    a = Integer.parseInt(st.nextToken());
	    b = Integer.parseInt(st.nextToken());
	    
	    while(a!=-1 && b!=-1){
	        list.get(a).add(b);
	        list.get(b).add(a);
	        
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	    }
	    
	    int count = 0, score = N+1, res;
	    for(int i=1;i<=N;i++){
	        res = cal(i);
	       // System.out.println(res+" "+i);
	        if(score == res) {
	            count++;
	            sb.append(i).append(" ");
	        }else if(score > res){
	            count = 1;
	            score = res;
	            sb.setLength(0);
	            sb.append(i).append(" ");
	        }
	    }
	    sb.insert(0, "\n");
	    sb.insert(0, count);
	    sb.insert(0, " ");
	    sb.insert(0, score);
		System.out.println(sb);
	}
	static int cal(int idx){
	    int temp, size, count = 0;
	    
	    Arrays.fill(visit, false);
	    visit[idx] = true;
	    
	    queue.clear();
	    for(int j : list.get(idx)){
            if(visit[j]) continue;
            visit[j] = true;
            queue.offer(j);
        }
	    
	    while(!queue.isEmpty()){
	        size = queue.size();
	        count++;
	        for(int i=0;i<size;i++){
	            temp = queue.poll();
	            for(int j : list.get(temp)){
	                if(visit[j]) continue;
	                visit[j] = true;
	                queue.offer(j);
	            }
	        }
	    }
	    return count;
	}
}
