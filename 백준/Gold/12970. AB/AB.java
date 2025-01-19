import java.util.*;
import java.io.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();
    static int N, M, A = -1;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<N;i++){
	        if((N-i)*i >= M){
	            A = i;
	            check();
	            break;
	        }
	    }
	    if(A<0) sb.append("-1");
	    
		System.out.println(sb);
	}
	static void check(){
	    int sum = 0;
	    for(int i=N-1; i>=0; i--){
	        if(sum+i-A+1<=M && A>0) {
	            sum += i-A+1;
	            A--;
	            sb.append("A");
	        }else sb.append("B");
	    }
	}
}
