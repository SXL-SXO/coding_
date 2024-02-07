package bj_coding;

import java.util.*;
import java.io.*;

public class 중앙이동알고리즘_2903 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer getNum = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(getNum.nextToken());
        int M = 2;
        for(int i = 1; i<N+1; i++){
            M=M*2-1;
        }
        System.out.print(M*M);
    }
}
