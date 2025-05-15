import java.util.*;
import java.io.*;

public class Main{
 
    static long N, lo, hi, mid;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Long.parseLong(br.readLine());
        
        // FFFFTTTTT의 형태, 제곱근 -> 얘의 제곱이 같거나 크면 된다 low
        
        lo = 0;
        hi = N;
        
        while(lo+1<hi){
            mid = (lo+hi)/2;
            if(!(Math.pow(mid, 2)>=N)) lo = mid;
            else hi = mid;
        }
        
        
		System.out.println(hi);
	}
}
