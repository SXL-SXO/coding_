import java.util.*;
import java.io.*;

public class 소수찾기_1978 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int number = Integer.parseInt(br.readLine());
        int num[] = new int [number];
        int answer = 0;
        StringTokenizer str = new StringTokenizer(br.readLine());
		for(int j=0;j<number;j++){
			num[j] = Integer.parseInt(str.nextToken());
        }
        for(int i=0;i<number;i++){
            if(num[i]==2)
                answer+=1;
            else if(num[i]==1 || num[i]%2==0)
                continue;
            else if((int)Math.sqrt((double)num[i])*Math.sqrt((double)num[i])==num[i])
                continue;
            else{
                answer+=1;
                for(int k=3;k<Math.sqrt((double)num[i]);k+=2){
                    if(num[i]%k==0){
                        answer-=1;
                        break;
                    }
                }
                
            }
        }

        System.out.print(answer);

    }
}