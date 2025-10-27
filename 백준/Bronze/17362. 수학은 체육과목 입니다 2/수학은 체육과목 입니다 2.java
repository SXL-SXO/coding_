import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//0일때 2, 6일때 4, 4로 나눠서 3이 나오면 3, 이 조건들이 다 안맞으면 N%8 출력
		if(N % 8 == 0) {
			System.out.println(2);
		}else if(N % 4 == 3) {
			System.out.println(3);
		}else if(N % 8 == 6) {
			System.out.println(4);
		}else {
			System.out.println(N % 8);
		}
	}

}