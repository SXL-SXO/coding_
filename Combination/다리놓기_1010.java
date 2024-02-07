import java.io.*;
import java.util.*;

public class 다리놓기_1010 {
    public static long factori (int a, int end){
        //System.out.print(a+" ");
        if (end<a)
            return a*factori(a-1,end);
        else
            return 1;

    }
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        int n , m;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            if(n!=m && m-n>n) n = m-n;
            long b, c, d;
            if(m>n+10) {b = factori(m,n+10); c = factori(n+10,n); d = factori(m-n,0);

                if(c%256==0 && d%256==0){
                    c=c/256;
                    d=d/256;
                }
            }
            else {b = factori(m,n); c=1; d=factori(m-n,0);}
            //System.out.println(b +" "+ c +" " + d);
            answer.append(b * c / d +"\n");
        }
        System.out.print(answer);
    }   
}
