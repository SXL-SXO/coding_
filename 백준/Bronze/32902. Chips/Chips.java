import java.util.*;
import java.io.*;

public class Main
{
    static int K, N;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    K = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    
		System.out.println(N+1+" "+(N*K+1));
	}
}
