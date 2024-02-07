package my_study;

import java.io.*;
import java.util.*;

public class 스위치켜고끄기_1244 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        boolean []onoff = new boolean[N]; //true:on:1, false:off:0

        for(int i=0;i<N;i++){
            if(st.nextToken().equals("0")) onoff[i] = false;
            else onoff[i] = true;
        }
        int M = Integer.parseInt(br.readLine());
        
        int people[][] = new int[M][2];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        for(int j=0;j<M;j++){
            if(people[j][0]==1){
                for(int i=people[j][1];i<onoff.length;i+=(people[j][1]+1)) {
                    onoff[i] = !onoff[i];
                }
                // for(int i=0;i<onoff.length;i++){
                //     System.out.print(onoff[i]+" /");
                // }
            }else{
                onoff[people[j][1]] = !onoff[people[j][1]];
                for(int i=1;i<onoff.length;i++) {
                    if(people[j][1]+i>=onoff.length || people[j][1]-i<0)
                        break;
                    if(onoff[people[j][1]+i]==onoff[people[j][1]-i]){
                        onoff[people[j][1]+i] = !onoff[people[j][1]+i];
                        onoff[people[j][1]-i] = !onoff[people[j][1]-i];
                    }
                    else break;
                }
                // for(int i=0;i<onoff.length;i++){
                //     System.out.print(onoff[i]+" ");
                // }
            }
        }
        for(int i=0;i<onoff.length;i++){
            if(onoff[i])
                answer.append(1).append(" ");
            else
                answer.append(0).append(" ");
                
            if((i+1)%20==0) answer.append("\n");
        }
        System.out.println(answer.toString());
    }
    
   
}
