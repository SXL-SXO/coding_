import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int total = 250;
		
		if(s > a && (s - a) % b == 0) {
			total += ((s - a) / b) * 100;
		}else if(s > a && (s - a) % b != 0) {
			total += (((s - a) / b) + 1) * 100;
		}
		
		System.out.println(total);
		sc.close();
	}
}
