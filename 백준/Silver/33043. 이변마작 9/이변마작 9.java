import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static String input[];
    static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    
	    N = Integer.parseInt(br.readLine());
	    
	    input = br.readLine().split(" ");
	    
	    int s = -1, e = N+1, m;
	    // fffsssss, 최소 큰 거
	    
	    while(s+1<e){
	       // System.out.print(s+" "+e+" | ");
	        m = (s+e)/2;
	        if(!check(m)) s = m;
	        else e = m;
	    }
	    
	    System.out.print(e==N+1 ? -1 : e);
	}
	static boolean check(int num){
	    map.clear();
	    
	    for(int i=0;i<num;i++){
	        map.put(input[i], map.getOrDefault(input[i], 0)+1);
	        if(map.get(input[i])>=5) return true;
	    }
	    
	    for(int i=num;i<N;i++){
	        map.put(input[i-num], map.getOrDefault(input[i-num], 0)-1);
	        map.put(input[i], map.getOrDefault(input[i], 0)+1);
	        if(map.get(input[i])>=5) return true;
	    }
	    return false;
	}
}
