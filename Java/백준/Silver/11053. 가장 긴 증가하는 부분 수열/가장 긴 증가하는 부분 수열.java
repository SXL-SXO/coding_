import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = 1;
    static int input[], small[], big[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[N];
	    small = new int[N];
	    big = new int[N];
	    st = new StringTokenizer(br.readLine());
	    
	    
	    int i, j;
	    input[0] = Integer.parseInt(st.nextToken());
	    for(i=1;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	        for(j=i-1; j>=0; j--){
	            if(input[j]<input[i]) {
	                small[i] = Math.max(small[i], small[j]+1);
	            }
	        }
	        answer = Math.max(answer, small[i]+1);
	    }
        System.out.print(answer);
	}
}
