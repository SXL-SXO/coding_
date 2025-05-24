import java.util.*;
import java.io.*;
public class Main
{
    static boolean answer = false;
    static boolean input[] = new boolean[26];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int c;
	    for(int i=0;i<3;i++){
	        c = br.readLine().toLowerCase().charAt(0)-'a';
	        
	        if(c<0 || c>=26) continue;
	        input[c] = true;
	    }
	    answer = input['l'-'a'] & input['k'-'a'] & input['p'-'a'];
	    
		if(answer) System.out.println("GLOBAL");
		else System.out.println("PONIX");
	}
}
