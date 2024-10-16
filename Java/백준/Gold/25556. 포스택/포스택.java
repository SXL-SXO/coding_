import java.util.*;
import java.io.*;

public class Main
{
    static String answer = "YES";
    static int input[];
    static int N;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    
	    input = new int [N];
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    
	    if(N>4){
	        int temp[] = {-1, input[0], 0, 0, 0};
	        int idx, count = 1;
	        
	        for(int i=1;i<N;i++){
	            idx = 0;
	            for(int j=1;j<=count;j++){
	                if(input[i]<temp[j]) continue;
	                else if(temp[idx] < temp[j]) idx = j;
	            }
	            if(idx==0){
	                if(count < 4) temp[++count] = input[i];
	                else{
    	                answer = "NO";
    	                break;
	                }
	            } else temp[idx] = input[i];
	        }
	    } 
	    System.out.print(answer);
	}
}
