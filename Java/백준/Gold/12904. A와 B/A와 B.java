import java.util.*;
import java.io.*;
public class Main
{
    static String S;
    static StringBuilder T;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    S = br.readLine();
	    T = new StringBuilder(br.readLine());
	    
	    for(int i=T.length();i>S.length();i--){
	        if(T.charAt(i-1)=='A') T.setLength(i-1);
	        else {
	            T.setLength(i-1);
	            T.reverse();
	        }
	    }
	    
	    if(S.equals(T.toString())) System.out.print(1);
	    else System.out.print(0);
	}
}
