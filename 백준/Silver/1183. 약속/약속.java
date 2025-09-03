import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer;
    static int A[], B[], diff[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    A = new int[N];
	    B = new int[N];
	    diff = new int[N];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        A[i] = Integer.parseInt(st.nextToken());
	        B[i] = Integer.parseInt(st.nextToken());
	        diff[i] = B[i]-A[i];
	    }
	    
	    if(N%2 == 1) answer = 1;
	    else{
	        Arrays.sort(diff);
	        answer = Math.abs(diff[N/2-1]-diff[N/2])+1;
	    }
	    
	    System.out.print(answer);
	}
}
