import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4_11659 {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int num[] = new int[N]; 

        st = new StringTokenizer(br.readLine());
        num[0] = Integer.parseInt(st.nextToken());
        for(int i=1;i<N;i++){
            num[i] = num[i-1] + Integer.parseInt(st.nextToken());
        }

        int temp;
        for(int j=0;j<M;j++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            temp = num[e];
            if(s>0) temp -= num[s-1];
            answer.append(temp).append("\n");
        }

        System.out.println(answer.toString());
    }
}
