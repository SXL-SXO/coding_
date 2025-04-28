import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, R, count = 1;
    static List<List<Integer>> link = new ArrayList<>();
    static int visit[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken())-1;
	    
	    visit = new int[N];
	    for(int i=0;i<N;i++) link.add(new ArrayList<>());
	    
	    int a, b;
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken())-1;
	        b = Integer.parseInt(st.nextToken())-1;
	        
	        link.get(a).add(b);
	        link.get(b).add(a);
	    }
	    for(int i=0;i<N;i++) Collections.sort(link.get(i));
	    
	    dfs(R);
	    answer();
	    
		System.out.println(sb);
	}
	static void answer(){
	    for(int i=0;i<N;i++) sb.append(visit[i]).append("\n");
	}
	static void dfs(int start){
	    visit[start] = count++;
	    
	    for(int n:link.get(start)) if(visit[n]==0) dfs(n);
	}
}
