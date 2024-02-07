package bj_coding;

import java.io.*;
import java.util.*;

public class 수학은비대면강의입니다_19532 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer getNum = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(getNum.nextToken());
        int b = Integer.parseInt(getNum.nextToken());
        int c = Integer.parseInt(getNum.nextToken());
        int d = Integer.parseInt(getNum.nextToken());
        int e = Integer.parseInt(getNum.nextToken());
        int f = Integer.parseInt(getNum.nextToken());

        int x,y;
        y = b*d-e*a!=0 ? (c*d-f*a)/(b*d-e*a) : 0;
        x = a!=0 ? (c-b*y)/a : (f-e*y)/d;
        System.out.print(x + " " +y);
    }
}
