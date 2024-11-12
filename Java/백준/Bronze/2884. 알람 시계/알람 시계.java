import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    int H = sc.nextInt(), M = sc.nextInt();
	    
	    H = M-45 < 0 ? H-1 < 0 ? 23 : H-1 : H;
	    M = M-45 < 0 ? 60+M-45 : M-45;
	    
		System.out.println(H+" "+M);
	}
}
