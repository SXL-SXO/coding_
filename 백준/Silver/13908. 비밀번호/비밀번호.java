import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer = 0;
    static int input[], num[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    num = new int[N];
	    
	    for(int i=0;i<10;i++) {
	        num[0] = i;
	        make(1);
	    }
	    
	    System.out.print(answer);
	}
	static void make(int idx){
	    if(idx==N){
	        int check = 0;
	        for(int i=0;i<N;i++){
	            for(int j=0;j<M;j++){
	                if(num[i] == j) check |= 1<<j;
	            }
	        }
	        if(check == (1<<M) - 1) {
	           // System.out.println(Arrays.toString(num));
	            answer++;
	        }
	        return;
	    }
	    
	    for(int i=0;i<10;i++) {
	        num[idx] = i;
	        make(idx+1);
	    }
	}
}
