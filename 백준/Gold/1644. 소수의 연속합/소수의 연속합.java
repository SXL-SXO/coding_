import java.io.*;
import java.util.*;

public class Main
{
    static int N, count = 2_000_000, answer = 0;
    static int sosu[];
    static boolean num[] = new boolean[4_000_001];
    public static void main(String[] args) throws Exception {
        init();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    
        int start = 0, end = 0, sum =0;
        for(;end<count;end++){
            if(sosu[end]>N) break;
            sum += sosu[end];
            if(sum>=N){
                if(sum==N) answer++;
                for(;start<=end;){
                    sum -= sosu[start++];
                    if(sum<N) break;
                    else if(sum==N) answer++;
                }
            }
        }
        System.out.print(answer);
    }
    static void init(){
        for(int j=4;j<=4_000_000;j+=2){
            num[j] = true;
        }
        for(int i=3;i<4_000_000;i+=2){
            if(num[i]) {
                count-=1;
                continue;
            }
            for(int j=i*3;j<4_000_000;j+=i){
                num[j] = true;
            }
        }
        
        int k = 0;
        sosu = new int [count];
        sosu[k++] = 2;
        for(int i=3;i<=4_000_000;i+=2){
            if(!num[i]) sosu[k++] = i;
        }
    }
}
