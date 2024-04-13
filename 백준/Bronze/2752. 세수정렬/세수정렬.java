import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num[] = new int[3];
        num[0] = Integer.parseInt(st.nextToken());
        num[1] = Integer.parseInt(st.nextToken());
        num[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        for(int i = 0; i < 3; i++){
            sb.append(num[i]).append(" ");
        }
        System.out.print(sb);
    }
}