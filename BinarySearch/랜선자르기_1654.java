import java.io.*;
import java.util.*;

public class 랜선자르기_1654 {
    static int K, N;
    static int len[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        len = new int[K];

        long max = 0, min = 0 ;
        for(int i=0;i<K;i++){
            len[i] = Integer.parseInt(br.readLine());
            max += (long)len[i];
        }
        min = 1; max/=N;
        while(min<=max){
            long mid = (min+max)/2L;
            int count = 0;
            for(int i=0;i<K;i++){
                count += len[i]/mid;
            }
            if(count<N) { 
                max = mid-1; 
            }
            else { 
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
}
