import java.util.*;
import java.io.*;
public class Main
{
    static int N, K, answer = 0;
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    int L, temp = 0;
	    char input[] = ("0"+Integer.toBinaryString(N)).toCharArray();
	    L = input.length;
	    
	    if(L-1<=K) System.out.print(0);
	    else{
	        int count = 0;
	        for(int i=0;i<L;i++){
	            if(count == K-1 ) {
	                temp = (int)Math.pow(2, L-1-i) - N%(int)Math.pow(2, L-1-i);
                }
	            if(input[i] == '1') count++;
	        }
	        if(count > K) answer = temp;
		    System.out.println(answer);
	    }
	}
}
