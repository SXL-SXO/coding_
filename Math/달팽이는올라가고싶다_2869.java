import java.util.*;
import java.io.*;

public class 달팽이는올라가고싶다_2869 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer getNum = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(getNum.nextToken());
        int B = Integer.parseInt(getNum.nextToken());
        int V = Integer.parseInt(getNum.nextToken());

        int answer = (V-A)/(A-B) + 2;
        
        if((V-A)%(A-B)==0)
            answer-=1;

        System.out.print(answer);
    }
}