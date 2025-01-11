import java.util.*;
import java.io.*;
public class Main
{
    static boolean num[] = new boolean[101];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    for(int i=1; i<10; i++){
	        for(int j=i; j<10;j++){
	            num[i*j] = true;
	        }
	    }
	    int N = Integer.parseInt(br.readLine());
	    if(num[N]) System.out.println(1);
	    else System.out.println(0);
	}
}
