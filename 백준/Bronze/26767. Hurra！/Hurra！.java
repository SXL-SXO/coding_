import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			if(i % 7 == 0 && i % 11 != 0) {
				sb.append("Hurra!\n");
			}else if(i % 7 != 0 && i % 11 == 0) {
				sb.append("Super!\n");
			}else if(i % 7 == 0 && i % 11 == 0) {
				sb.append("Wiwat!\n");
			}else {
				sb.append(i).append("\n");
			}
		}
        System.out.print(sb);
		sc.close();
	}
}