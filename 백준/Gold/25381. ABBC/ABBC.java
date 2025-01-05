import java.io.*;
import java.util.*;

public class Main
{
    static Queue<Integer> a = new ArrayDeque<>(); 
    static Queue<Integer> b = new ArrayDeque<>(); 
    static PriorityQueue<Integer> b_ = new PriorityQueue<>((o1, o2)-> o2-o1);
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
	    
	    
	    int tmp1, tmp2, bigger = -1;
	    
	    // b-c 짝지어 제거
	    while(!b.isEmpty() && !c.isEmpty()){
	        tmp1 = b.poll();
	        tmp2 = c.peek();
	        
	        
	        if(tmp1<tmp2) {
	            c.poll();
	            answer++;
	        }else b_.offer(tmp1);
	    }
	    
	    // b 재정렬, 제일 큰 녀석 제일 앞인지 체크하는 용임
	    while(!b.isEmpty()){
	        b_.offer(b.poll());
	    }
	    
	    // a-b 짝지어 제거
	    while(!a.isEmpty() && !b_.isEmpty()){
	        tmp1 = a.poll();
	        tmp2 = b_.peek();
	        
	        if(tmp1<tmp2) {
	            b_.poll();
	            answer++;
	        }
	    }
		System.out.println(answer);
	}
}
