package bj_coding;
import java.util.*;
import java.io.*;

public class 약수구하기_2501 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer getNum = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(getNum.nextToken());
        int K = Integer.parseInt(getNum.nextToken());

        StringBuilder sd_f = new StringBuilder("1 ");

        for(int i=2;i<=(int)Math.sqrt(N);i++){
            if(N%i==0){
                sd_f.append(i+" ");
            }
        }
        String []num = sd_f.toString().split(" ");

        if(K<=num.length) System.out.print(num[K-1]);
        else if(K>num.length*2) System.out.print(0);
        else if((int)Math.sqrt(N)*(int)Math.sqrt(N)==N ){
            if(K>num.length*2-1) System.out.print(0);
            else System.out.print(N/Integer.parseInt(num[num.length*2-1-K]));
        }
        else{
            System.out.print(N/Integer.parseInt(num[num.length*2-K]));
        }

    }
}