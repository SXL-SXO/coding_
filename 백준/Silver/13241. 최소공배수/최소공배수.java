import java.util.*;
import java.io.*;

public class Main
{
    static long A, B, answer;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    A = Long.parseLong(st.nextToken());
	    B = Long.parseLong(st.nextToken());
	    
	    answer = gcd(A, B);
	    
	    System.out.print(A*B/answer);
	}
	static Long gcd(long a, long b){
	    if(a == 0) return b;
	    return gcd(b%a, a);
	}
}
