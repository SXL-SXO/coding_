import java.util.*;
import java.io.*;

public class 색종이_2563 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
        int answer=0;
        boolean arr[][] = new boolean [100][100];
        for(int i=0;i<count;i++){
		    StringTokenizer getNum = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(getNum.nextToken());
            int b = Integer.parseInt(getNum.nextToken());
            for(int j=a;j<a+10;j++){
                for(int k=b;k<b+10;k++){
                    arr[j][k]=true;
                }
            }
        }
        for(int a=0;a<100;a++){
            for(int b=0;b<100;b++){
                    answer = arr[a][b]==true ? answer+=1: answer;
            }
        }
        System.out.print(answer);
    }
}