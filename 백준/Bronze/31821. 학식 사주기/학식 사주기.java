import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); // 메뉴의 개수
		
		int[] price = new int[n + 1]; // 메뉴의 가격을 저장하는 배열
		for (int i = 1; i <= n; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0; // 총 내야될 가격
		n = Integer.parseInt(br.readLine()); // 새내기의 인원 수
		for (int i = 0; i < n; i++) {
			int index = Integer.parseInt(br.readLine()); // 먹고 싶어하는 메뉴
			sum += price[index];
		}
		
		bw.write(Integer.toString(sum));
		bw.flush();
		bw.close();
		br.close();
	}
}