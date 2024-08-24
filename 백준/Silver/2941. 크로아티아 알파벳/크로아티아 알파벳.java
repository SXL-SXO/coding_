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
		int cnt = 0;
		for(int i = 0; i < 8; i++){
		    input = input.replace(alpha[i], ".");
		    
		    answer += (len - input.length()) / (alpha[i].length()-1);
		    len = input.length();
		}
		input = input.replace(".", "");
		System.out.println(answer + input.length());
	}
}
