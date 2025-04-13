import java.io.*;
import java.util.*;
public class Main
{
    static int T;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        check(Long.parseLong(br.readLine()));
	    }
	    
	    System.out.print(sb);
	}
	static void check(long l){
	    while(!isPrime(l)){
	        l++;
	    }
	    sb.append(l).append("\n");
	}
	static boolean isPrime(long b){
	    if(b==0||b==1||(b!=2 && b%2==0)) return false;
	    
	    long max = (long)Math.sqrt(b);
	    for(long a=3;a<=max;a+=2){
	        if(b%a==0) return false;
	    }
	    return true;
	}
}
