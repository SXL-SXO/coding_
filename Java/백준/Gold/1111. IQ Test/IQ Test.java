import java.util.*;
import java.io.*;

public class Main
{
    static int N, A, B;
    static double a = 0, b = 0, c;
    static int input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[N];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    // b==So*4 일 경우
	    if(N==1) sb.append("A");
	    else if(N==2){
	        if(input[0]==input[1]) sb.append(input[0]);
	        else sb.append("A");
	    }
	    else if(input[0]==input[1]) {
	        int i;
	        for(i=1;i<N;i++){
	            if(input[0]==input[i]) continue;
	            sb.append("B");
                break;
	        }
            if(sb.length()==0) sb.append(input[0]);
	    }
	    else solved();
	     
		System.out.println(sb);
	}
	public static void solved(){
	    a = (input[2]-input[1])/(input[1]-input[0]);
	    b = input[1]-input[0]*a;
	    A = (int)a;
	    B = (int)b;
	    
	   // System.out.println(a+" "+A+" "+b+" "+B);
	    if(a-A !=0.0 || b-B != 0.0) {
            sb.append("B");
            return;
        }else{
            for(int i=1;i<N;i++){
	            if(input[i-1]*A+B==input[i]) continue;
	           // System.out.println(input[i-1]*A+B+" "+input[i]);
	            sb.append("B");
	            return;
	        }
        }
        sb.append(input[N-1]*A+B);
	} 
}
