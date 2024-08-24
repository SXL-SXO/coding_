import java.util.*;
import java.io.*;

public class Main
{
	static int answer = 0;
    static String input;
    static String alpha[] = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine();
	    
	    int len = input.length();
        input = input.replaceAll(alpha[0], "0");
        answer += (len-input.length())/2;
	    
	    for(int i=1;i<8;i++){
	        len = input.length();
            input = input.replaceAll(alpha[i], "0");
            answer += (len-input.length());
	    }
	    	
    	input = input.replaceAll("0", "");
    	System.out.println(answer+input.length());
	}
}
