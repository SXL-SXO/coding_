import java.io.*;
import java.util.*;
public class Main
{
    static int N, M;
    static Long answer = 0L, now = 0L;
    static int time[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    time = new int[N];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        M = Integer.parseInt(st.nextToken());
	        for(int j=0;j<M;j++){
	            time[i] += Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    Arrays.sort(time);
	    
	    for(int i=0;i<N;i++){
	        now += time[i];
	        answer += now;
	    }
	    
		System.out.print(answer);
	}
}
