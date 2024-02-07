
package bj_coding;
import java.util.*;
import java.io.*;

public class 세로읽기_10798 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        String arr[] = new String [5];
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<5;i++){
            StringBuilder str = new StringBuilder(br.readLine());
            while(str.length()<30){
                str.append("  ");
            }
            arr[i]=str.toString();
            //System.out.println(arr[i]);
        }
        for(int a=0;a<30;a++){
            for(int b=0;b<5;b++){
                    answer.append(arr[b].charAt(a));
            }
        }
        System.out.print(answer.toString().replaceAll(" ", ""));
    }
}