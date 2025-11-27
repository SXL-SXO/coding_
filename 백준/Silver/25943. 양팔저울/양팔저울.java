import java.util.*;
import java.io.*;
public class Main
{
    static int N, R = 0, L = 0, diff, answer = 0;
    static int input[];
    public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    input = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) {
	        input[i] = Integer.parseInt(st.nextToken());
	        if(R<L) R += input[i];
	        else L += input[i];
	    }
	    
	    if(R!=L){
	        diff = Math.abs(R-L);
	        answer += diff/100;
	        diff %= 100;
	        
	        answer += diff/50;
	        diff %= 50;
	        
	        answer += diff/20;
	        diff %= 20;
	        
	        answer += diff/10;
	        diff %= 10;
	        
	        answer += diff/5;
	        diff %= 5;
	        
	        answer += diff/2;
	        diff %= 2;
	        
	        answer += diff;
	    }
	    
	    System.out.print(answer);
	}
}
