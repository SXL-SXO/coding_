import java.util.*;
import java.io.*;
public class Main
{
    static String input[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split("\\.");
		System.out.print(input[0]);
    }
}