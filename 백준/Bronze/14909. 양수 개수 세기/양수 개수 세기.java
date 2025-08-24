import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = 0;
        while (st.hasMoreTokens()) {
            if (Integer.valueOf(st.nextToken()) > 0) {
                count++;
            }
        }

        System.out.println(count);

        br.close();
    }

}