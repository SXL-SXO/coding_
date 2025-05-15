import java.util.*;
import java.io.*;

public class Main{
    static int input[];
    static long N, M, min, lo, hi, mid;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        
        input = new int[(int)N];
        min = input[0] = Integer.parseInt(br.readLine());
        for(int i=1;i<N;i++) {
            input[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, input[i]);
        }
        
        lo = 0;
        hi = min * M;
        
        // 내가 구해야하는 것 
        // 1) 걸리는 총 최대 시간, 
        // 
        // 2) 각 심사관에게 부여해야하는 시간
        //      FFFFTTTTT의 형태, 제일 작게 걸리는 시간이므로 lower
        
        
        while(lo+1<hi){
            mid = (lo+hi)/2;
            if(!check(mid)) lo = mid;
            else hi = mid;
            // System.out.println(lo+" "+mid+" "+hi);
        }
		System.out.println(hi);
	}
	static boolean check(long val){
	    long count = 0;
	    
	    for(int i : input) count += val/(long)i;
	    
	    return count >= M;
	}
}
