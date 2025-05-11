import java.util.*;
import java.io.*;

public class Main
{
    static int N, val = 1;
    static int answer[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    answer = new int[N+1];
	    
	    answer[1] = val++;
	    sb.append(answer[1]).append(" ");
	    
	    for(int i=2;i<=N;i++){
	        if(answer[i] == 0){
    	        answer[i] = val;
    	        for(int j=2;i*j<=N;j++){
    	            if(answer[i*j] == 0) answer[i*j] = val;
    	        }
    	        val++;
	        }
	        sb.append(answer[i]).append(" ");
	    }
	    sb.insert(0, "\n");
	    sb.insert(0, --val);
	    System.out.print(sb);
	}
}
