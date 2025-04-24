import java.util.*;
import java.io.*;
public class Main
{
    static int T, N, count;
    static int input[] = new int[20];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        st = new StringTokenizer(br.readLine());
	        sb.append(st.nextToken());
	        
	        for(int i=0;i<20;i++){
	            input[i] = Integer.parseInt(st.nextToken());
	        }
	        count = 0;
	        for(int i=19;i>=0;i--){
	            for(int j=i-1;j>=0;j--){
	                if(input[i]<input[j]) count++;
	            }
	        }
	        sb.append(" ").append(count).append("\n");
	    }
	    System.out.print(sb);
	}
}