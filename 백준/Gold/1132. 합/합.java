import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static String[] arr;
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new String[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
            max = Math.max(max, arr[i].length());
        }

        long[][] cnt = new long[max][10];

        for (int i = 0; i < N; i++) {
            String s = arr[i];
            int len = s.length();
            int start = max - len;
            for (int j = 0; j < len; j++) {
                int n = s.charAt(j) - 'A';
                if(j == 0) visited[n] = true;
                cnt[start + j][n]++;
            }
        }
        long[] result = new long[10];
        long weight = 1;
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < 10; j++) {
                result[j] += cnt[i][j] * weight;
            }
            weight *= 10;
        }
        int smallIdx = -1;
        long amount = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if(!visited[i]){
                if(result[i] < amount){
                    amount = result[i];
                    smallIdx = i;
                }
            }
        }
        result[smallIdx] = 0;
        Arrays.sort(result);
        int pi = 0;
        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += result[i] * pi;
            pi++;
        }

        System.out.println(ans);
    }
}