import java.io.*;
import java.util.*;
public class Main
{
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String input[][];
    static String name[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    for(int t=1;;t++){
	        N = Integer.parseInt(br.readLine());
	        if(N==0) break;
	        
	        input = new String[N][N-1];
	        name = new String[N];
	        
	        for(int i=0;i<N;i++){
	            st = new StringTokenizer(br.readLine());
	            name[i] = st.nextToken();
	            for(int j=0;j<N-1;j++){
	                input[i][j] = st.nextToken();
	            }
	        }
	        
	        
	        sb.append("Group ").append(t).append("\n");
	        
	        int count = 0, k = 0;
	        for(int i=0;i<N;i++){
	            k = i-1;
                for(int j=0;j<N-1;j++){
                    if(k==-1){
                        k=N-1;
                        j--;
                        continue;
                    }
                    if(input[i][j].equals("N")){
                        sb.append(name[k]).append(" was nasty about ").append(name[i]).append("\n"); 
                        count++;
                    }
                    k--;
    	        }
	        }
	        if(count == 0) sb.append("Nobody was nasty\n");
	        sb.append("\n");
	        
	    }
		System.out.println(sb);
	}
}
