import java.util.*;
import java.io.*;

public class Main
{
    static int T, M, N, X, Y;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    
	    int a, b;
	    total : for(int t=0;t<T;t++){
	        st = new StringTokenizer(br.readLine());
	        M = Integer.parseInt(st.nextToken());
	        N = Integer.parseInt(st.nextToken());
	        X = Integer.parseInt(st.nextToken())-1;
	        Y = Integer.parseInt(st.nextToken())-1;
	        
	        a = Y%M;
	        b = Y;
	        
	        for(int i=Y+1;i<=(M+1)*(N+1);i+=N){
	            if(a==X) {
	                sb.append(i).append("\n");
	                continue total;
	            }else if(a==M-1 && b==N-1) break;
	            
	            a = (N+a)%M;
	        }
	        sb.append(-1).append("\n");
	    }
	    System.out.print(sb);
	}
}
