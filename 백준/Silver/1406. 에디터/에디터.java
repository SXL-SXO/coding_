import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static char order[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    sb.append(br.readLine());
	    N = Integer.parseInt(br.readLine());
	    
	    int idx = sb.length();
	    for(int i=0;i<N;i++){
	        order = br.readLine().toCharArray();
	        if(order[0] == 'L' && idx>0) idx--;
	        else if(order[0] == 'D' && idx<sb.length()) idx++;
	        else if(order[0] == 'B' && idx>0) sb.deleteCharAt(idx-- -1);
	        else if(order[0] == 'P') {
	            if(idx==sb.length()) sb.append(order[2]);
	            else sb.insert(idx, order[2]);
	            idx++;
	        }
	    }
	    System.out.print(sb);
	}
}