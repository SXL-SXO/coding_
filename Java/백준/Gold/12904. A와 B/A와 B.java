import java.util.*;
import java.io.*;
public class Main
{
    static String S;
    static StringBuilder T;
    static int len_T;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    S = br.readLine();
	    T = new StringBuilder(br.readLine());
	    
	    len_T = T.length();
	    for(int i=len_T;i>S.length();i--){
	        if(T.charAt(i-1)=='A') T.setLength(i-1);
	        else {
	            T = new StringBuilder(T.substring(0, i-1));
	            T.reverse();
	        }
	    }
	    
	    if(S.equals(T.toString())) System.out.print(1);
	    else System.out.print(0);
	}
}
