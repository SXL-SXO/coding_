import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		int n = sc.nextInt();
		
		int total = a + b + c + d;
		int newAverage = total;
		int count = 0;
		while(newAverage / 4 < n) {
			count++;
			newAverage = total + count;
		}
		System.out.println(count);
		sc.close();
	}
}