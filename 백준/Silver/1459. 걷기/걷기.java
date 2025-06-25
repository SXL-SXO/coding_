import java.util.*;
import java.io.*;

public class Main
{
    static long X, Y, W, S, answer;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    X = Long.parseLong(st.nextToken());
	    Y = Long.parseLong(st.nextToken());
	    W = Long.parseLong(st.nextToken());
	    S = Long.parseLong(st.nextToken());
	    
	    
	    answer = (X+Y)*W;
	    answer = Math.min(answer, Math.min(X, Y)*S + Math.abs(X-Y)*W);
	    answer = Math.min(answer, Math.max(X, Y)*S + ((X+Y)%2 == 0 ? 0 : -S+W));
	    
	    System.out.print(answer);
	}
}
