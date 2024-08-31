import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = Integer.MIN_VALUE;
    static Long num[];
    static char input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    input = br.readLine().toCharArray();
	    
	    num = new Long [N/2];
	    for(int i=0;i<N/2;i++){
	        switch(input[i*2+1]){
	            case '+': num[i] = Long.valueOf(input[i*2]-'0') + Long.valueOf(input[(i+1)*2]-'0'); break;
	            case '-': num[i] = Long.valueOf(input[i*2]-'0') - Long.valueOf(input[(i+1)*2]-'0'); break;
	            case '*': num[i] = Long.valueOf(input[i*2]-'0') * Long.valueOf(input[(i+1)*2]-'0'); break;
	        }
	    }
	    
	    if(N>=3){
    	    cal(1, Long.valueOf(input[0]-'0'), Long.valueOf(input[0]-'0'), N>1 ? input[1]!='-' : true);
    	    cal(2, num[0], num[0], N>3 ? input[3]!='-' : true);
	    }else{
	        answer = input[0]-'0';
	    }
	    
		System.out.println(answer);
	}
	static void cal(int idx, Long val, Long before, boolean is_plus){
	    if(idx*2-1==N) {
	        answer = Math.max(answer, val.intValue());
	        return;
	    }
	    
	    Long next = Long.valueOf(input[idx*2]-'0');
	    switch(input[idx*2-1]){
	        case '+': cal(idx+1, val+next, next, true); break;
	        case '-': cal(idx+1, val-next, next, false); break;
	        case '*': 
	            if(is_plus) cal(idx+1, val-before+before*next, before*next, is_plus);
	            else cal(idx+1, val+before-before*next, before*next, is_plus); 
	            break;
	    }
	    
	    if(idx>=N/2) return;
	    switch(input[idx*2-1]){
	        case '+': cal(idx+2, val+num[idx], num[idx], true); break;
	        case '-': cal(idx+2, val-num[idx], num[idx], false); break;
	        case '*':
	            if(is_plus) cal(idx+2, val-before+before*num[idx], before*num[idx], is_plus);
	            else cal(idx+2, val+before-before*num[idx], before*num[idx], is_plus); 
	            break;
	    }
	}
}
