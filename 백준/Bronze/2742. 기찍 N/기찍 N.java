import java.io.BufferedReader;
import java.io.InputStreamReader;
class Main{
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = N; i >= 1; i--){
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}