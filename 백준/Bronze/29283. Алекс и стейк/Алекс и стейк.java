import java.util.*;
import java.io.*;
public class Main
{
    static long N, M;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Long.parseLong(br.readLine());
	    if(N<=5) {System.out.print(N*30);
	    return;
	    }
	    M = 5-N%5;
	    N = (N+5)/5;
	    System.out.print((1+N)*N*75 - M*N*30);
	}
}
