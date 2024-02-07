import java.io.*;
import java.util.*;

public class 대표값2_2587 {
        public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num[] = new int [5];
        int answer = 0;
        for(int i=0;i<5;i++){
            num[i] = Integer.parseInt(br.readLine());
            answer+=num[i];
        } 
        Arrays.sort(num);
        System.out.print(answer/5+"\n"+num[2]);
    }
}
