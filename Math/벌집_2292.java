import java.util.*;
import java.io.*;

public class 벌집_2292 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer getNum = new StringTokenizer(br.readLine());

        long N = (long)Integer.parseInt(getNum.nextToken());
        long num = 2;
        int M = 1;
        if (N==1){ System.out.print(M);}
        else{
            while(true){
                //System.out.println(num+"와 " +(num+6*M)+"사이");
                if(num<=N && N<num+6*M)
                    break;
                num=num+6*M;
                M++;
            }
        System.out.print(M+1);
        }
    }
}
