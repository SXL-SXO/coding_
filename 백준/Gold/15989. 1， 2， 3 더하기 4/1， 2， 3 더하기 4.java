import java.io.*;
import java.util.*;

/**
 * B_123더하기4_
 */
public class Main {
    static int T, N, answer;
    static int dp[][] = new int[10001][4];
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            sb.append(fun(3,N)+fun(2,N)+fun(1,N)).append("\n");
        }
        System.out.println(sb.toString());
    }
    static int fun(int s, int num){
        int re=0;
        if (s>num) return 0;
        else if(s==num || s==1) return 1;
        else if(dp[num][s]!=0) return dp[num][s];
        for(int i=1;i<=s;i++){
            re += fun(i, num-s);
        }
        return dp[num][s] = re;
    }
}