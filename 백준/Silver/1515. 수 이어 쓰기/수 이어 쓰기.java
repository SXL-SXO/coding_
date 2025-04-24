import java.util.*;
import java.io.*;
public class Main
{
    static char input[], temp[];
    static int N, answer = 1;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    N = input.length;
	    
	    int idx = 0;
	    total : for(;;answer++){
	        temp = String.valueOf(answer).toCharArray();
	        for(char c : temp) {
	            if(c == input[idx]) idx++;
	            if(idx == N) break total;
	        }
	    }
	    System.out.print(answer);
	}
}