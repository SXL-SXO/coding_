import java.io.*;
import java.util.*;

public class 통계학_2108 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int input[] = new int[N];
        int num[] = new int[8001];
        long div = 0;
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(br.readLine());
            num[input[i]+4000]+=1;
            div+=input[i];
        }
        
        Arrays.sort(input);

        int mode_f = input[0], mode_s = input[0], count = num[input[0]+4000];
        for(int i=input[0]+1;i<=input[N-1];i++){
            //System.out.println(mode_f+" "+ mode_s);
            if(num[i+4000]>count){
                mode_f = i;
                mode_s = i;
                count = num[i+4000];
            }
            else if(num[i+4000]==count && mode_f==mode_s ){
                mode_s = i;
            }
        }
        //System.out.println(Arrays.toString(input));
        
        sb.append(Math.round((double)div/N)).append("\n").append(input[N/2]).append("\n")
            .append(mode_s).append("\n").append(input[N-1]-input[0]).append("\n");
        System.out.println(sb.toString());
    }
}
