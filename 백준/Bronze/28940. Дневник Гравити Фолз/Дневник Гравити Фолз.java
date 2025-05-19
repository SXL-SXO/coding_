import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int Acount = (w / a) * (h / b);
		int pageTotal = 0;
		
		if(w < a || h < b) {
			System.out.println("-1");
		}else {
			if(n % Acount != 0) {
				pageTotal = (n / Acount) + 1;
			}else {
				pageTotal = n / Acount;
			}
			System.out.println(pageTotal);
		}
		
		sc.close();
	}
}