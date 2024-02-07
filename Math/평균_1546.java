import java.io.*;
import java.util.*;

public class 평균_1546 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        int N = Integer.parseInt(br.readLine());
        int test[] = new int [N];
        int max = 0;
        double answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            test[i] = Integer.parseInt(st.nextToken());
            max = test[i] > max ? test[i] : max;
        }
        for(int i=0;i<N;i++){
            answer += (double)test[i]/max*100/N;
            
        }
        System.out.print(answer);

    }
}
