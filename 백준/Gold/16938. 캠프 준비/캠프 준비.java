import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N, L, R, X, answer = 0;
    static int pro[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        pro = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pro[i] = Integer.parseInt(st.nextToken());
        }

        check(0, 0, Integer.MAX_VALUE, -1, 0L);
        System.out.println(answer);
    }
    static void check(int idx, int count, int min, int max, Long sum){
        if(idx>=N) {
//            System.out.println(idx+", "+count+", "+min+", "+max+", "+sum);
            if(count>=2 && L<=sum && sum<=R && max-min>=X) answer++;
            return;
        }
        check(idx+1, count, min, max, sum);
        check(idx+1, count+1, Math.min(min, pro[idx]), Math.max(max, pro[idx]), sum+pro[idx]);
    }
}