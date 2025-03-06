import java.util.*;
import java.io.*;
public class Main
{
    static int T, a, b, idx, len, len_a, len_b;
    static char input_a[], input_b[], res[];
    static boolean dp[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=1;t<=T;t++){
	        st = new StringTokenizer(br.readLine());
	        
	        input_a = st.nextToken().toCharArray();
	        input_b = st.nextToken().toCharArray();
	        res = st.nextToken().toCharArray();
	        
	        len_a = input_a.length;
	        len_b = input_b.length;
	        len = res.length;
	        
	        dp = new boolean[len_a+1][len_b+1];
	        dp[0][0] = true;
	        
	        for(int i=0;i<len_a;i++) {
	            if(input_a[i] == res[i]) dp[i+1][0] = true;
	            else break;
	        }
	        for(int i=0;i<len_b;i++) {
	            if(input_b[i] == res[i]) dp[0][i+1] = true;
	            else break;
	        }
	      
	        for(int i=1; i<=len; i++){
    	        for(int a=1; a<=len_a; a++){
    	            b = i-a;
    	            if(a>i ) break;
    	            else if(b>len_b || b<=0) continue;
    	            
    	            if(dp[a-1][b] && input_a[a-1]==res[i-1]) dp[a][b] = true;
    	            else if(dp[a][b-1] && input_b[b-1]==res[i-1]) dp[a][b] = true;
    	        }
	        }
	        
	       // for(int i=0;i<=len_a;i++) System.out.println(Arrays.toString(dp[i]));
	       // System.out.print("\n");
	        if(dp[len_a][len_b]) sb.append("Data set ").append(t).append(": ").append("yes").append("\n");
	        else sb.append("Data set ").append(t).append(": ").append("no").append("\n");
	        
	    }
	    System.out.print(sb);
	    
	}
	
}


