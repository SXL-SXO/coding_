import java.util.*;
import java.io.*;
public class Main
{
    static int A_p, A_c, B_p, B_c, answer_p, answer_c;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    A_c = Integer.parseInt(st.nextToken());
	    A_p = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    B_c = Integer.parseInt(st.nextToken());
	    B_p = Integer.parseInt(st.nextToken());
	    
	    answer_p = A_p*B_p;
	    answer_c = A_p*B_c + B_p*A_c;
	    
	    int div = GCD(answer_p, answer_c);
	    
	    sb.append(answer_c/div).append(" ").append(answer_p/div);
	    System.out.print(sb);
	}
	static int GCD(int A, int B){
	    if(B == 0) return A;
	    
	    return GCD(B, A%B);
	}
}
