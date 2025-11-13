import java.util.*;
import java.io.*;
public class Main
{
    static int K, A, B, answer_i;
    static double answer;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    K = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    A = Integer.parseInt(st.nextToken());
	    B = Integer.parseInt(st.nextToken());
	    
	    answer = K*K - (double)(A-B)*(A-B)/4;
        answer_i = (int)answer;
	    
		if(answer_i-answer < 0.0) System.out.println(answer);
        else System.out.print(answer_i);
	}
}
