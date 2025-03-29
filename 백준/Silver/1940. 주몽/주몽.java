import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static int input[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    input = new int[N];
	    for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
	    Arrays.sort(input);
	    
	    int s = 0, e = N-1, answer = 0;
	    
	    while(s<e){
	       // System.out.println(s+" "+e+" "+input[s]+" "+input[e]);
	        if(input[s]+input[e]==M) answer++;
	        
	        if(Math.abs(input[s+1]+input[e]-M)<Math.abs(input[s]+input[e-1]-M)) s++;
	        else e--;
	    }
	    
		System.out.println(answer);
	}
}
