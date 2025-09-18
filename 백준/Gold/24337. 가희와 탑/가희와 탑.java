import java.util.*;
import java.io.*;
public class Main
{
    static int N, A, B;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
	    
	    if(A+B-1 == N) {
	        for(int i=1;i<A;i++) sb.append(i).append(" ");
	        sb.append(Math.max(A, B)).append(" ");
            for(int i=B-1;i>0;i--) sb.append(i).append(" ");
	    }else if(A+B-1 > N) sb.append(-1);
	   // else if(A==1 && B==1) for(int i=1;i<=N;i++) sb.append(1).append(" ");
	    else if(A==1){
	        sb.append(B).append(" ");
	        for(int i=1;i<=N-B;i++) sb.append(1).append(" ");
	        for(int i=B-1;i>0;i--) sb.append(i).append(" ");
	    }else if(B==1){
	        for(int i=1;i<=N-A;i++) sb.append(1).append(" ");
	        for(int i=1;i<=A;i++) sb.append(i).append(" ");
	    }else if(A<B){
	        for(int i=0;i<=N-A-B;i++) sb.append(1).append(" ");
	        for(int i=1;i<A;i++) sb.append(i).append(" ");
	        for(int i=B;i>0;i--) sb.append(i).append(" ");
	    }else {
	        for(int i=0;i<=N-A-B;i++) sb.append(1).append(" ");
	        for(int i=1;i<=A;i++) sb.append(i).append(" ");
	        for(int i=B-1;i>0;i--) sb.append(i).append(" ");
	    }
	    
	    System.out.print(sb);
	}
}
