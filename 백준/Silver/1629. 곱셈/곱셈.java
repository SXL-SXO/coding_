import java.io.*;
import java.util.*;

public class Main {
    static Long A,B,C,answer = 1L;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        mul(A,B,C);
        System.out.println(answer);
    }
    static void mul(long a, long b, long c){
        while(b>0){
            a%=c;
            if(b%2==1){
                answer*=a;
                answer%=c;
            }
            a*=a;
            b/=2;

        }
    }
}
