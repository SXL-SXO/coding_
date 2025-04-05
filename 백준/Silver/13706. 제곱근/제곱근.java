import java.math.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BigInteger a = new BigInteger(br.readLine());
	    System.out.print(a.sqrt());
	}
}
