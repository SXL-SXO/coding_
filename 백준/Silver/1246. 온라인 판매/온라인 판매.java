import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int N, M, answer_p = 0, answer_i = 0, total = 0;
    static int egg[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        egg = new int[M];
        for(int i = 0; i < M; i++){
            egg[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(egg);

        for(int i = 0; i < M; i++){
            if(M-i >= N) total = N * egg[i];
            else total = (M-i) * egg[i];
            if(answer_p < total) {
                answer_p = total;
                answer_i = i;
            }
        }

        System.out.println(egg[answer_i]+" "+answer_p);
    }
}