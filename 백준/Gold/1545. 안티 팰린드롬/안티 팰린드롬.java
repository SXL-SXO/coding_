import java.util.*;
import java.io.*;

public class Main
{
    static int N, a = 0, b = 0;
    static char input[], output[];
    static int alpa[] = new int[26];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    N = input.length;
	    output = new char[N];
	    Arrays.fill(output, '.');
	    
	    for(char c : input) alpa[c-'a']++;
	    
	    
	    before();
	    after();
	    check();
	    
	    
		System.out.println(sb);
	}
	static void check(){
	    for(char c : output){
	        if(c == '.'){
	            sb.setLength(0);
	            sb.append(-1);
	            return;
	        }
	        sb.append(c);
	    }
	}
	static void before(){
	    while(a<26 && b<=(N-1)/2){
	        if(alpa[a]<=0) a++;
	        else{
	            output[b++] = (char)(a+'a');
	            alpa[a]--;
	        }
	    }
	   // System.out.print(Arrays.toString(output));
	}
	static void after(){
	    int c = 0;
	    while(a<26 && c<N){
	        if(alpa[a]<=0) a++;
	        else{
	            for(c = b; c<N; c++){
	                if(output[c] != '.' || output[N-1-c] == (char)(a+'a')) continue;
	                output[c] = (char)(a+'a');
	                alpa[a]--;
	                break;
	            }
	        }
	    }
	   // System.out.print(Arrays.toString(output));
	}
}
