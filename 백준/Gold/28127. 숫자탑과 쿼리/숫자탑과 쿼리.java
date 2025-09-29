import java.util.*;
import java.io.*;
public class Main
{
	static int Q, A, B, X;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Q = Integer.parseInt(br.readLine());
		for(int q=0; q<Q; q++) {
			st = new StringTokenizer(br.readLine());

			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            if(X<=A) {
                sb.append("1 ").append(X).append("\n");
                continue;
            }
            
            long count = find(), sum = A*count + count*(count-1)/2*B;
            if(X-sum == 0) sb.append(count).append(" ").append((long)A+(long)B*(count-1)).append("\n");
            else sb.append(count+1).append(" ").append(X-sum).append("\n");
		}
            // (A + A+B*(count-1))*count/2
		System.out.println(sb);
	}
	static long find(){
	    long lo = 0, hi = 1000001, mi;
	    
	    while(lo+1<hi){
	        mi = (lo+hi)/2;
	       // TTTTTF
	        if(check(mi)) lo = mi;
	        else hi = mi;
	    }
	    return lo;
	}
	static boolean check(long val){
	    return A*val + (val-1)*val/2*B <= X;
	}
}
