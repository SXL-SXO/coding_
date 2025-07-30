import java.io.*;
import java.util.*;

public class Main {
    static int N, answer = 0;
    static char input[];
    static Queue<Character> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = br.readLine().toCharArray();
        int balance = 0;
        for (char c : input) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            answer = Math.max(answer, Math.abs(balance));
        }

        // 최종 균형이 0이 아니면 불가능
        System.out.println(balance == 0 ? answer : -1);
    }
}