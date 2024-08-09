import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())).append("\n");
	    }
	    System.out.print(sb);
	}
}
