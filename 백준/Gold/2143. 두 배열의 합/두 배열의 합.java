import java.util.*;
import java.io.*;

public class Main
{
    static int T, A, B, len_A;
    static long answer = 0;
    static int input_a[], input_b[], sum_a[];
    static Map<Integer, Long> sum_b = new HashMap<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    
	    A = Integer.parseInt(br.readLine());
	    len_A = (1+A)*A/2;
	    input_a = new int[A];
	    sum_a = new int[len_A];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<A;i++){
	        input_a[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    B = Integer.parseInt(br.readLine());
	    input_b = new int[B];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<B;i++){
	        input_b[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int temp, idx = 0;
	    for(int i=0;i<A;i++){
	        temp = 0;
	        for(int j=i;j<A;j++){
	            temp += input_a[j];
	            sum_a[idx++] = temp;
	        }
	    }
	   
	    for(int i=0;i<B;i++){
	        temp = 0;
	        for(int j=i;j<B;j++){
	            temp += input_b[j];
	            sum_b.put(temp, sum_b.getOrDefault(temp, 0L)+1);
	        }
	    }
	   
	    
	    for(int i=0;i<len_A;i++){
	        answer += sum_b.getOrDefault(T-sum_a[i], 0L);
	    }
	    
	    System.out.print(answer);
	}
}
