import java.util.*;
import java.io.*;
public class Main
{
    static int input[];
    static int N, S, answer = 0, start=-1, end, total = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
		    input[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++){
		    total += input[i];
		    
		    if(total>=S) {
        	    start = 0;
        	    end = i;
        	    // 앞쪽 줄여서 사이즈 최소로 만들기
        	    if(total>S) smaller();
        	    // 슬라이딩 윈도우로 체크하기
		        check();
		        break;
		    }
		}
		
		if(start!=-1) answer = end-start;
		System.out.print(answer);
	}
	static void smaller(){
	    for(;start<end;){
	        total-=input[start++];
	        if(total<S) {
	            total+=input[--start];
	            break;
	        }
	    }
	}
	static void check(){
        end++;
	    for(;end<N;){
	        total -= input[start++];
	        total += input[end];
	        
	        if(total>S) smaller();
	        
	        end++;
	    }
	}
}
