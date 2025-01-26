import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, idx = 0, count = 0;
    static char input[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		
		for(idx=0;idx<N-2*M;idx++){
		    if(input[idx]=='I') check(M);
		}
		System.out.print(count);
	}
	static void check(int turn){
	    if(turn==0) {
	        count++;
	        if(idx+2<N) check(1);
	        return;
	    } if(idx+2>N) return;
	   if(input[idx+1]=='O'){
    	    idx++;
	        if(input[idx+1]=='I') {
	            idx++;
	            check(turn-1);
	        }
	    }
	}
}
