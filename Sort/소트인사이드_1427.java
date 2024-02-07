package bj_coding;

import java.io.*;
import java.util.*;

public class 소트인사이드_1427 {
        public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        StringBuilder answer = new StringBuilder();
        String num[] = N.split("");
        Arrays.sort(num);

        for(int i=0; i<num.length;i++){
            answer.append(num[num.length-1-i]);
        }
        System.out.print(answer);
    }
}
