import java.io.*;
import java.util.*;

public class 커트라인_25305 {
        public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer getNum = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(getNum.nextToken()), K = Integer.parseInt(getNum.nextToken());
        StringTokenizer getNum2 = new StringTokenizer(br.readLine());

        int num[] = new int [N];

        for(int i=0; i<N;i++){
            num[i] = Integer.parseInt(getNum2.nextToken());
        } 
        Arrays.sort(num);
        System.out.print(num[N-K]);
    }
}
