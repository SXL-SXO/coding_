package bj_coding;
import java.util.*;
import java.io.*;
public class 설탕배달_2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        
        int answer_5=N/5, answer_3=(N-5*answer_5)/3, answer_per=(N-answer_5*5-answer_3*3);
        while(true){
            if(answer_per==0||(answer_5==0&&answer_3!=0&&answer_per!=0))
                break;
            answer_5-=1;
            answer_3=(N-5*answer_5)/3;
            answer_per=N-answer_5*5-answer_3*3;
        }
        if(answer_per!=0) System.out.print("-1");
        else System.out.print(answer_5+answer_3);
    }
}
