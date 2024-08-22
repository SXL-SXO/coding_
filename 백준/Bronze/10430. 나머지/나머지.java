import java.util.*;
import java.io.*;

public class Main
{
	static int A, B, C;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        sb.append( (A+B)%C).append("\n").append(((A%C) + (B%C))%C).append("\n").append((A*B)%C).append("\n").append(((A%C) * (B%C))%C);
		System.out.println(sb);
	}
}
