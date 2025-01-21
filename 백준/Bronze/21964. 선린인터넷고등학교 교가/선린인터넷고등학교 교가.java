import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 문자열 길이
		String s = br.readLine(); // 문자열
		
		// 문자열의 뒤에서 5번째부터 끝까지만 저장한다.
		sb.append(s.substring(n - 5, n)); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}