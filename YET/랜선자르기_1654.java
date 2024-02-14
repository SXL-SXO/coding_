import java.io.*;
import java.util.*;

public class 랜선자르기_1654 {
    static int K, N, answer = 0;
    static int len[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        len = new int[K];

        long total = 0;
        for(int i=0;i<K;i++){
            len[i] = Integer.parseInt(br.readLine());
            total += (long)len[i];
        }
        answer = ran(((int)total/N),);
        System.out.println(String.valueOf(answer));
    }
    static int ran(int l, int u){
        int low = l, up = u;
        if(low==up) return up;
        long count = 0;
        for(int i=0;i<K;i++){
            count += (long)len[i]*2/(low+up);
        }
        if(count==N) return (int)((low+up)/2);
        else if(count>N) up = up - (low+up)/2;
        else low = low - (low+up)/2;
        return ran(low,up);
    }
}
