import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < num; i++) { 
            String s = br.readLine().trim();
            if (s.length() == 7 &&
                s.charAt(0) == s.charAt(1) &&
                s.charAt(0) == s.charAt(4) &&
                s.charAt(6) == s.charAt(2) &&
                s.charAt(6) == s.charAt(3) &&
                s.charAt(6) == s.charAt(5) &&
                s.charAt(0) != s.charAt(6)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}