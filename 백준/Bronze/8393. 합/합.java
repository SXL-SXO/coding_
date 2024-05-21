import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 1; i <= N; i++){
            answer+=i;
        }
        System.out.println(answer);
    }
}