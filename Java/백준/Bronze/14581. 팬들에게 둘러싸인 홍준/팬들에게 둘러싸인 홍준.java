import java.util.*;
import java.io.*;
public class Main
{
    
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    sb.append(":fan::fan::fan:\n:fan::").append(br.readLine()).append("::fan:\n:fan::fan::fan:");
		System.out.println(sb);
	}
}
