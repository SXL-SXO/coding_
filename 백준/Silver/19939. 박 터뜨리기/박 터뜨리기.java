import java.io.*;
import java.util.*;

public class Main {
	static int N, K, min, max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		min = (int)Math.floor(((N*2/(double)K-K+1))/2.0);
		if(min<1) 
			System.out.println(-1);
		else if( (min+min+K-1)*K/2.0 == N) 
			System.out.println(min+K-1-min);
		else 
			System.out.println(min+K-min);
	}
}
