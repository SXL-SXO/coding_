import java.io.*;
import java.util.*;

public class Main
{
    static int N;
    static long answer = 0;
    static int input[];
    static boolean num[] = new boolean[100001];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[N];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
	    
	    int start = 0, end = 1;
	    num[input[start]] = true;
	    
	    while(end<N){
	        if(!num[input[end]]){
	            num[input[end++]] = true;
	            continue;
	        }
	        
	        answer += end-start;
	        num[input[start++]] = false; 
	        if(end==start) {
	            num[input[start]] = true;
	            end++;
	        }
	    }
	    answer += (long)(end-start)*(long)(end-start+1)/2;
	    
		System.out.println(answer);
	}
}
