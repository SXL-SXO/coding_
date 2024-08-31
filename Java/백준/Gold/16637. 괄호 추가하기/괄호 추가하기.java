import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = Integer.MIN_VALUE;
    static int num[];
    static char input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    input = br.readLine().toCharArray();
	    
	    num = new int [N/2];
	    for(int i=0;i<N/2;i++){
	        switch(input[i*2+1]){
	            case '+': num[i] = (input[i*2]-'0') + (input[(i+1)*2]-'0'); break;
	            case '-': num[i] = (input[i*2]-'0') - (input[(i+1)*2]-'0'); break;
	            case '*': num[i] = (input[i*2]-'0') * (input[(i+1)*2]-'0'); break;
	            case '/': num[i] = (input[i*2]-'0') / (input[(i+1)*2]-'0'); break;
	        }
	    }
	    
	    cal(1, input[0]-'0');
	    
		System.out.println(answer);
	}
	static void cal(int idx, int val){
	    if(idx*2-1==N) {
	        answer = Math.max(answer, val);
	        return;
	    }
	    
	    switch(input[idx*2-1]){
	        case '+': cal(idx+1, val+(input[idx*2]-'0')); break;
	        case '-': cal(idx+1, val-(input[idx*2]-'0')); break;
	        case '*': cal(idx+1, val*(input[idx*2]-'0')); break;
	        case '/': cal(idx+1, (int)val/(input[idx*2]-'0')); break;
	    }
	    
	    if(idx>=N/2) return;
	    switch(input[idx*2-1]){
	        case '+': cal(idx+2, val+num[idx]); break;
	        case '-': cal(idx+2, val-num[idx]); break;
	        case '*': cal(idx+2, val*num[idx]); break;
	        case '/': cal(idx+2, (int)val/num[idx]); break;
	    }
	}
}
