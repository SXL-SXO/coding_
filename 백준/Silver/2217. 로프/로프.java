import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static int input[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[N];
	    for(int i=0;i<N;i++) input[i] = Integer.parseInt(br.readLine());
	    
	    Arrays.sort(input);
	    for(int i=0;i<N;i++){
	        answer = Math.max(answer, input[i]*(N-i));
	    }
	    
	    System.out.print(answer);
	}
}
