import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static StringBuilder s;
    static char input[];
    static boolean visit[] = new boolean[26];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<N;i++){
	        s = new StringBuilder(br.readLine());
	        input = s.toString().toUpperCase().toCharArray();
	        
	        if(!visit[input[0]-'A']) {
	            visit[input[0]-'A'] = true;
	            start(0);
	        }else blank_start();
	        
	    }
	    
	    System.out.print(sb);
	}
	static void start(int idx){
	    sb.append(s.substring(0, idx)).append("[").append(s.charAt(idx)).append("]").append(s.substring(idx+1)).append("\n");
	}
	static void blank_start(){
	    for(int i=1;i<input.length;i++){
	        if(input[i-1]==' ' && !visit[input[i]-'A']) {
	            visit[input[i]-'A'] = true;
	            start(i);
	            return;
	        }
	    }
	    
	    for(int i=0;i<input.length;i++){
	        if(input[i]!=' ' && !visit[input[i]-'A']) {
	            visit[input[i]-'A'] = true;
	            start(i);
	            return;
	        }
	    }
	    
	    sb.append(s).append("\n");
	}
}
