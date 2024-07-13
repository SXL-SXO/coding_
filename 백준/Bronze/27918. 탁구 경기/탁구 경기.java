import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int N, D = 0, S = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            if(br.readLine().equals("D")) D++;
            else S++;

            if(Math.abs(D-S)>=2) break;
        }
        sb.append(D).append(":").append(S);
        System.out.println(sb);
    }
}