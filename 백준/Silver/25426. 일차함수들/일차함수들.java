import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static long a = 0;
    static long input[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new long[N];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = Long.parseLong(st.nextToken());
	        a += Integer.parseInt(st.nextToken());
	    }
		Arrays.sort(input);
		
		for(int i=1;i<=N;i++) a+=input[i-1]*i;
		
		System.out.println(a);
	}
}
