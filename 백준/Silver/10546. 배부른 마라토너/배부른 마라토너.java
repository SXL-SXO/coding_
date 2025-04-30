import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static Map<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    String input;
	    for(int i=0;i<N*2-1;i++){
	        input = br.readLine();
	        map.put(input, map.getOrDefault(input, 0)+1);
	    }
	    
	    for(String s : map.keySet()) if(map.get(s)%2==1) System.out.println(s);
	}
}
