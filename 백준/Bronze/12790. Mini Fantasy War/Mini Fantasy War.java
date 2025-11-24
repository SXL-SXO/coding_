import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine()); // 테스트 케이스의 수
		for(int i=0; i<T; i++) {
			st = new StringTokenizer(bf.readLine());
			int[] ability = new int[8];	// HP, MP 공, 방, 증감되는 HP, MP, 공, 방
			for(int j=0; j<8; j++) {
				ability[j] = Integer.parseInt(st.nextToken());
			}
			
			// 최종 능력치 = 기본 능력치 + 장비 능력치
			for(int j=0; j<4; j++) {
				ability[j] += ability[j+4];
			}
			
			// HP, MP가 1보다 작은경우 1로 간주, 공격력은 0보다 작은경우 0으로 간주
			ability[0] = (ability[0] < 1) ? 1 : ability[0];
			ability[1] = (ability[1] < 1) ? 1 : ability[1];
			ability[2] = (ability[2] < 0) ? 0 : ability[2];
			
			// 전투력 = 1 * (HP) + 5 * (MP) + 2 * (공격력) + 2 * (방어력)
			int result = ability[0] + (ability[1]*5) + (ability[2]*2) + (ability[3]*2);
			System.out.println(result);
		}
		bf.close();
	}
}