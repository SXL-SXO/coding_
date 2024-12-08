import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[30];
		
		// 30명 중 출석부 번호가 들어온 곳 1로 표시
		for (int i = 0 ; i < 28 ; i++) {
			int num = sc.nextInt();
			arr[num-1] = 1;
		}
		
		for (int i = 0 ; i < arr.length ; i++) {
			if (arr[i] != 1) {
				System.out.println(i+1);
			}
		}
		
	}
}