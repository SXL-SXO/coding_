import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String answer[] = {"", "2024 8", "2025 3", "2025 10", "2026 5", "2026 12"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(answer[Integer.parseInt(br.readLine())]);
    }
}
