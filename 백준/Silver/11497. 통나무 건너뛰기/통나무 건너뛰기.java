import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int T, N, max;
    static int L[], L_s[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            L = new int[N];
            L_s = new int[N];

            for(int i=0;i<N;i++){
                L[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(L);

            for(int i=0;i<N;i++){
                if(i%2==0) L_s[i/2] = L[i];
                else L_s[N-1-i/2] = L[i];
            }

            max = Math.abs(L_s[0]-L_s[N-1]);
            for(int i=0;i<N-1;i++){
                max = Math.max(max, Math.abs(L_s[i]-L_s[i+1]));
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb.toString());
    }
}