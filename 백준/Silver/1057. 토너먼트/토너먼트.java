import java.util.*;
import java.io.*;
public class Main
{
    static int N, a, b, answer = 1;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    a = Integer.parseInt(st.nextToken())-1;
	    b = Integer.parseInt(st.nextToken())-1;
	    
	    
	    while(a/2 != b/2){
	        answer++;
	        a/=2;
	        b/=2;
	    }
	    
	    System.out.print(answer);
	}
}