import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int num[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    num = new int [N+1];
	    Arrays.fill(num, N);
	    num[N] = 0;
	    
	    for(int i=N; i>1 ;i--){
	        if(i%2==0) num[i/2] = Math.min(num[i/2], num[i]+1);
	        if(i%3==0) num[i/3] = Math.min(num[i/3], num[i]+1);
	        num[i-1] = Math.min(num[i-1], num[i]+1);
	       // System.out.println(i+" "+Arrays.toString(num));
	    }
		System.out.println(num[1]);
	}
}
