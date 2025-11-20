import java.util.*;
import java.io.*;

public class Main
{
    static char input[];
    static Map<Character, Character> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    input = br.readLine().toCharArray();
	    
	    map.put('E', 'I');
	    map.put('I', 'E');
	    map.put('S', 'N');
	    map.put('N', 'S');
	    map.put('F', 'T');
	    map.put('T', 'F');
	    map.put('P', 'J');
	    map.put('J', 'P');
	    
	    for(char c : input) sb.append(map.get(c));
	    
		System.out.println(sb);
	}
}
