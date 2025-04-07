import java.util.*;
import java.io.*;
public class Main
{
    static String input;
    static int N, K, S;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    input = st.nextToken();
	    K = input.charAt(0)-'A' + (input.charAt(1)-'1')*10;
	    input = st.nextToken();
	    S = input.charAt(0)-'A' + (input.charAt(1)-'1')*10;
	    N = Integer.parseInt(st.nextToken());
	    
	    char c;
	    int nky, nkx, nsy, nsx;
	    for(int i=0;i<N;i++){
	        input = br.readLine();
	        
	        nky = K/10;
	        nkx = K%10;
	        nsy = S/10;
	        nsx = S%10;
	        
	        for(int j=0;j<input.length();j++){
    	        c = input.charAt(j);
    	        if(c == 'R'){
    	            nkx += 1;
    	            nsx += 1;
    	        }else if(c == 'L'){
    	            nkx -= 1;
    	            nsx -= 1;
    	        }else if(c == 'B'){
    	            nky -= 1;
    	            nsy -= 1;
    	        }else if(c == 'T'){
    	            nky += 1;
    	            nsy += 1;
    	        }
            }
            
	            
            if(nky<0||nky>7 || nkx<0||nkx>7) continue;
            if(nky*10+nkx==S){
                if(nsy<0||nsy>7 || nsx<0||nsx>7) continue;
                S = nsy*10+nsx;
            }
	        K = nky*10+nkx;
	    }
	    
	    sb.append((char)(K%10+'A')).append(K/10+1).append("\n").append((char)(S%10+'A')).append(S/10+1);
		System.out.println(sb);
	}
}
