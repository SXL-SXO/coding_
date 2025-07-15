import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int t = 300;
	    for(int i=0;i<4;i++) t+=Integer.parseInt(br.readLine());
	    
	    if(t<=1800) System.out.println("Yes");
	    else System.out.println("No");
	}
}
