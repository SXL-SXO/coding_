import java.util.*;
import java.io.*;

public class Main
{
    static Map<Integer, Integer> map = new HashMap<>();
    static int A, P, num;
    static char input[];
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	A = Integer.parseInt(st.nextToken());
    	P = Integer.parseInt(st.nextToken());
    	
    	int count = 0;
    	map.put(A, count++);
    	input = String.valueOf(A).toCharArray();
    	while(true){
    	    num = 0;
    	    for(char c: input){
    	        num += Math.pow(c-'0', P);
    	    }
    	    if(map.containsKey(num)) {
    	        System.out.print(map.get(num));
    	        break;
    	    }else map.put(num, count++);
    	        
    	    input = String.valueOf(num).toCharArray();
    	}
	}
}
