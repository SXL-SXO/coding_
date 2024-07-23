import java.util.*;
import java.io.*;
public class Main

{
    static int N = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<4;i++){
		    N += Integer.parseInt(br.readLine());
		}
		System.out.print(N/60+"\n"+N%60);
	}
}
