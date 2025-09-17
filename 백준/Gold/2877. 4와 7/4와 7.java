import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static char input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = Integer.toString(Integer.parseInt(br.readLine())+1, 2).toCharArray();
	    N = input.length;
	    
	    for(int i=1;i<N;i++) sb.append(input[i] == '0' ? 4 : 7); 
	    
	    System.out.print(sb);
	}
}
