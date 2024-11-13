import java.util.*;
import java.io.*;

public class Main
{
    
	public static void main(String[] args) throws Exception{
	    Scanner sc = new Scanner(System.in);
	    int sum = 0, min = 101;
	    for(int i=0;i<4;i++){
	        int N = sc.nextInt();
	        sum += N;
	        min = Math.min(min, N);
	    }
	    sum-=min;
	    sum+=Math.max(sc.nextInt(), sc.nextInt());
	    
		System.out.println(sum);
	}
}
