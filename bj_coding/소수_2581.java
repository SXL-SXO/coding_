package bj_coding;

import java.util.*;
import java.io.*;

public class 소수_2581 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int answer[] = {0, 0};
        if(M%2==0){
            if(M==2){
                answer[0]=2;
                answer[1]=2;
                M+=2;
                if(N>=3)
                    answer[0]+=3;
            }
            for(int i=M+1; i<N+1; i+=2){
                for(int j=2;j<Math.sqrt(i)+1;j++){
                    if(i%j==0)
                        break;
                    if(j==(int)Math.sqrt(i)){
                        answer[0]+=i;
                        if(answer[1]==0)
                            answer[1]=i;
                    }
                }
            }
        }
        else{
            if(M==1 && N>=2){
                answer[0]+=2;
                answer[1]=2;
                M+=2;
            }
            if(M==3 && N>=3){
                answer[0]+=3;
                if(answer[1]==0) answer[1]=3;
                M+=2;
            }
            for(int i=M; i<N+1; i+=2){
                for(int j=2;j<Math.sqrt(i)+1;j++){
                    if(i%j==0)
                        break;
                    if(j==(int)Math.sqrt(i)){
                        answer[0]+=i;
                        if(answer[1]==0)
                            answer[1]=i;
                    }
                }
            }
        }
        if(answer[0]==0) System.out.print("-1");
        else System.out.print(answer[0]+"\n"+answer[1]);
    }
}
