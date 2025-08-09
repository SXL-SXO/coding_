import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int N, answer;
    static int input[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);

        answer = N%2==0 ? N/2-1 : N/2;
        System.out.println(input[answer]);
    }
}