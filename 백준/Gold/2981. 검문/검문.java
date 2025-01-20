import java.util.*;
import java.io.*;

public class Main
{
    static int N, GCD;
    static int input[], num[];
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    N = Integer.parseInt(br.readLine());
	    input = new int[N];
	    num = new int[N];
	    
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(br.readLine());
	    }
	    for(int i=0;i<N-1;i++){
	        num[i] = Math.abs(input[i]-input[i+1]);
	    }
	    num[N-1] = Math.abs(input[N-1]-input[0]);
	    Arrays.sort(num);
	    
	    GCD = num[0];
	    for(int a : num){
	        GCD = gcd(a, GCD);
	    }
	    
	    for(int i=2;i<Math.sqrt(GCD);i++){
	        if(GCD%i!=0) continue;
	        list.add(i);
	        list.add(GCD/i);
	    }
	    if(Math.sqrt(GCD) == (int)Math.sqrt(GCD)/1) list.add((int)Math.sqrt(GCD));
	    Collections.sort(list);
	    
	    for(int i: list){
	        sb.append(i).append(" ");
	    }
	    sb.append(GCD);
	    
	    System.out.print(sb);
	}
	static int gcd(int a, int b){
	    if(a<b){
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	    
	    if(a%b==0) return b;
	    
	    return gcd(b, a%b);
	}
}
