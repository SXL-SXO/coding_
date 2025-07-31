import java.util.*;
import java.io.*;
public class Main
{
    static int N, count = 0;
    static long M, answer = Long.MAX_VALUE;
    static Map<Long, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++){
	        M = Long.parseLong(br.readLine());
	        map.put(M, map.getOrDefault(M, 0)+1);
	    }
	    
	    for(Long l : map.keySet()){
	        if(count < map.get(l) || (count==map.get(l) && l<answer)) {
	            answer = l;
	            count = map.get(l);
	        }
	    }
		System.out.println(answer);
	}
}
