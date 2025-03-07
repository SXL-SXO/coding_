import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer;
    static int input[], res[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    input = new int[N];
	    res = new int[N];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) res[i] = Integer.parseInt(st.nextToken());
	    
	    answer = insert() ? 1:0;
	    
	    System.out.print(answer);
	}
	static boolean insert(){
	    int idx, temp;
	    for(int i=1;i<N;i++){
	        idx = i-1;
	        temp = input[i];
	        
	        while(0<=idx && temp<input[idx]){
	            input[idx+1] = input[idx--];
	            if(check()) return true;
	        }
	        
	        if(idx+1!=i) input[idx+1] = temp;
	        if(check()) return true;
	    }
	    return false;
	}
	static boolean check(){
	    for(int i=0;i<N;i++) if(input[i]!=res[i]) return false;
	    return true;
	}
	
}


