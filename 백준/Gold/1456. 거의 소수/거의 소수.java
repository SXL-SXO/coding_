import java.util.*;
import java.io.*;
public class Main
{
    static Map<Long, Integer> map = new HashMap<>();
    static boolean sosu[] = new boolean[10000001];
    static long N, M;
    static int answer;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Long.parseLong(st.nextToken());
	    M = Long.parseLong(st.nextToken());
	    
	    init();
	    
	    int max = (int)Math.sqrt(M);
	    long val;
	        
	    for(int i=2;i<=max;i++){
	        if(sosu[i]) continue;
	        
	        val = i;
	        for(int j=2;;j++) {
	            val *= i;
	            if(val<N) continue;
	            else if(val>M) break;
	            
	           // System.out.println(Math.pow(i, j)+" "+i+" "+j);
	            answer++;
	            if(val > Long.MAX_VALUE / i) break;
	        }
	    }
	    
	    System.out.print(answer);
	}
	static void init(){
	    for(int i=4;i<10000001;i+=2) sosu[i] = true;
	    for(int i=3;i<5000000;i+=2){
	        if(sosu[i]) continue;
	        for(int j=3;i*j<10000000;j+=2){
	            sosu[i*j] = true;
	        }
	    }
	}
}