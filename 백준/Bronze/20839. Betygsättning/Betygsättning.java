import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a == x && b == y && c == z) {
			System.out.println("A");
		}else if(a >= (x + 1) / 2 && b == y && c == z) {
			System.out.println("B");
		}else if(b == y && c == z) {
			System.out.println("C");
		}else if(b >= (y + 1) / 2 && c == z) {
			System.out.println("D");
		}else {
			System.out.println("E");
		}
		sc.close();
	}
}
