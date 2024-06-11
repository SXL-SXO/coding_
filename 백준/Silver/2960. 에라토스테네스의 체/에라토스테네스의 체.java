import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N, K;
    static boolean num[] = new boolean[1001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i=2;i<=N;i++){
            if(num[i]) continue;
            for(int j=1;j<=500;j++){
                if(i*j>N) break;
                else if(num[i*j]) continue;
                num[i*j] = true;
                count++;
                if(count==K) {
                    System.out.println(i * j);
                    return;
                }
            }
        }
    }
}