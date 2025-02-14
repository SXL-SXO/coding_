import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int answer[];
    static int num[] = {1, 2, 3};
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		
		answer[0] = 1;
		fill(1);
		
		System.out.print(sb);
	}
	static void fill(int idx){
	    if(idx==N) {
	        for(int a : answer)
	            sb.append(a);
            return;
	    }
	   
	    if(answer[idx-1] == 1){
	        answer[idx] = 2;
	        if(check(idx)) fill(idx+1);
	        answer[idx] = 3;
	        if(sb.length()==0 && check(idx)) fill(idx+1);
	    }else if(answer[idx-1] == 2){
	        answer[idx] = 1;
	        if(check(idx)) fill(idx+1);
	        answer[idx] = 3;
	        if(sb.length()==0 && check(idx)) fill(idx+1);
	    }else{
	        answer[idx] = 1;
	        if(check(idx)) fill(idx+1);
	        answer[idx] = 2;
	        if(sb.length()==0 && check(idx)) fill(idx+1);
	    }
	}
	static boolean check(int idx){
	    boolean is;
	    for(int len=2;len<=(idx+1)/2;len++){
	        is = false;
	        for(int i=1;i<=len;i++){
	            if(answer[idx-len+i]!=answer[idx-len*2+i]) {
	                is = true;
	                break;
	            }
	        }
	        if(!is) return false;
	    }
	    return true;
	}
	
}
