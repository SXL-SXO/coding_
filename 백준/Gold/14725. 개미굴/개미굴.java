import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static Map<String, List<String>> map = new HashMap<>();
    static Map<String, Integer> visit = new HashMap<>();
    static StringBuilder answer = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    
	    N = Integer.parseInt(br.readLine());
	    
	    String now, before = "_";
	    
	    map.put("0", new ArrayList<>());
	    List<String> temp;
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        M = Integer.parseInt(st.nextToken());
	        
	        now = st.nextToken();
	        temp = map.get("0");
	        temp.add(now);
	        
            sb = new StringBuilder("0");
	        for(int j=1;j<M;j++){
	            before = now;
	            now = st.nextToken();
	            
	            sb.append(" ").append(before);
	            
	            temp = map.getOrDefault(sb.toString(), new ArrayList<>());
	            temp.add(now);
	            map.put(sb.toString(), temp);
	        }
	    }
	    
	    for(String key : map.keySet()) {
	        Collections.sort(map.get(key));
	       // System.out.println(key +" "+map.get(key));
	    }
	    
	    for(String s : map.get("0")) {
	        dfs(1, "0", s);
	    }
	    
		System.out.println(answer.toString());
	}
	static void dfs(int idx, String before, String s){
	    StringBuilder sb = new StringBuilder(before);
	    sb.append(" ").append(s);
	    if(visit.containsKey(sb.toString())) return;
	    visit.put(sb.toString(), 0);
	    
	    
	    for(int i=0;i<idx-1;i++) answer.append("--");
        answer.append(s).append("\n");
	    for(String ss : map.getOrDefault(sb.toString(), new ArrayList<>())){
	        dfs(idx+1, sb.toString(), ss);
	    }
	}
}
