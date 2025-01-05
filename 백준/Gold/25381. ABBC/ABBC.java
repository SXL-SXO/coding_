import java.io.*;
import java.util.*;

public class Main
{
    static Queue<Integer> a = new ArrayDeque<>(); 
    static Queue<Integer> b = new ArrayDeque<>(); 
    static Queue<Integer> c = new ArrayDeque<>(); 
    static int answer = 0;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    char input[] = br.readLine().toCharArray();
	    
	    for(int i=input.length-1; i>=0; i--){
	        switch(input[i]){
	            case 'A' : a.offer(i); break;
	            case 'B' : b.offer(i); break;
	            case 'C' : c.offer(i); break;
	        }
	    }
	    
	    
	    int tmp1, tmp2;
	    
	    // a-b 짝지어 제거
	    while(!b.isEmpty() && !a.isEmpty()){
	        tmp1 = a.poll();
	        tmp2 = b.peek();
	        
	        if(tmp1<tmp2) {
	            answer++;
	            b.poll();
	        }
	    }
	    
	    // b-c 짝지어 제거
	    while(!c.isEmpty() && !b.isEmpty()){
	        tmp1 = b.poll();
	        tmp2 = c.peek();
	        
	        if(tmp1<tmp2) {
	            answer++;
	            c.poll();
	        }
	    }
		System.out.println(answer);
	}
}
