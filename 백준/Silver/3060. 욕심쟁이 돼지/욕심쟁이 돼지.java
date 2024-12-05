import java.util.*;
import java.io.*;

public class Main
{
    static int T, N;
    static Long sum;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        N = Integer.parseInt(br.readLine());
	        st = new StringTokenizer(br.readLine());
	        
	        sum = 0L;
	        for(int i=0;i<6;i++){
	            sum += Long.parseLong(st.nextToken());
	        }
	        
	        int day = 1;
	        while(sum<=N){
	            day++;
	            sum*=4;
	        }
	        sb.append(day).append("\n");
	    }
		System.out.println(sb);
	}
}
