import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input[] = br.readLine().split(" ");
	    
	    for(String s : input) {
	        if(!s.equals("1") && !s.equals("0")){
	            System.out.print("F");
	            return;
	        }
	    }
        
		System.out.println("S");
	}
}
