import java.io.*;
import java.util.*;

public class Main
{
    static char input[];
    static int idx_1, idx_2;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    idx_1 = 0;
	    for(int i=1;i<input.length-2;i++){
	        if(input[i]<input[idx_1]) idx_1 = i;
	        else if(input[i]==input[idx_1]){
	            for(int j=1;idx_1<=i-j;j++){
	                if(idx_1-j==-1 || input[idx_1-j] < input[i-j]) break;
	                else if(idx_1==i-j || input[i-j]<input[idx_1-j]){
	                    idx_1=i;
	                    break;
	                }
	            }
	        }
	    }     
	    
	    idx_2 = idx_1+1;
	    for(int i=idx_2+1;i<input.length-1;i++){
	        if(input[i]<input[idx_2]) idx_2 = i;
	        else if(input[i]==input[idx_2]){
	            for(int j=1;idx_2<=i-j;j++){
	                if(idx_2-j==-1 || input[idx_2-j] < input[i-j]) break;
	                else if(idx_2==i-j || input[i-j]<input[idx_2-j]){
	                    idx_2=i;
	                    break;
	                }
	            }
	        }
	    }
	    
	    
        // System.out.println(idx_1+" "+idx_2);
	    
	    for(int i=idx_1;i>=0;i--){
	        sb.append(input[i]);
	    }
	    for(int i=idx_2;i>idx_1;i--){
	        sb.append(input[i]);
	    }
	    for(int i=input.length-1;i>idx_2;i--){
	        sb.append(input[i]);
	    }
		System.out.println(sb);
	}
}
