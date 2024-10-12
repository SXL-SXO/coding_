import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static String answer;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    answer = N%2 == 1 ? "SK" : "CY";
		System.out.print(answer);
	}
}
