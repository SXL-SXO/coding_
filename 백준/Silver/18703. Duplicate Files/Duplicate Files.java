import java.util.*;
import java.io.*;

public class Main
{
    static int T, N, min;
    static String input[];
    static List<Integer> list = new ArrayList<>();
    static Map<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        N = Integer.parseInt(br.readLine());
	        map.clear();
	        for(int i=0;i<N;i++){
	            input = br.readLine().split(" ");
	            min = Math.min(Integer.parseInt(input[1]), map.getOrDefault(input[0], Integer.MAX_VALUE));
	            map.put(input[0], min);
	        }
	        list.clear();
	        for(int v : map.values()){
	            list.add(v);
	        }
	        Collections.sort(list);
	        for(int v:list){
	            sb.append(v).append(" ");
	        }
	        sb.append("\n");
	    }
	    
		System.out.println(sb);
	}
}
