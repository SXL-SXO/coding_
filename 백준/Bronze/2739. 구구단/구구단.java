import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i < 10; i++){
            sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
        }

        System.out.println(sb);
    }
}