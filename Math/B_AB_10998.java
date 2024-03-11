import java.io.*;
import java.util.StringTokenizer;

/**
 * B_AB_10998
 */
public class B_AB_10998 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken()));
    }
}