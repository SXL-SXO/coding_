import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class 랜선자르기_1654 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int len[] = new int[K];

        long total = 0;
        long vs[] = {1, (long)(total/N)};
        for(int i=0;i<K;i++){
            len[i] = Integer.parseInt(br.readLine());
            total += (long)len[i];
        }

        Arrays.sort(len);
        int mid, count;
        while(true){
            mid = (int)((vs[0]+vs[1])/2);
            count = 0;
            for(int j=len.length-1;j>-1;j--){
                count = (int)(len[j]/mid);
                if(count>N+1)

            }
        }
        BigDecimal answer = new BigDecimal(--mid);
        System.out.println(String.valueOf(answer));
    }
}
