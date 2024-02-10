import java.io.*;
import java.util.*;

public class 마인크래프트_18111 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int block[] = new int[258];
        int max = 256, min = 0;
    
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                block[Integer.parseInt(st.nextToken())] += 1;
            }
        }
        for(int i=0;i<=256;i++){
            if(block[i]==0) continue;

            min = i;
            break;
        }
        for(int i=256; i>=0;i--){
            if(block[i]==0) continue;
            max = i;
            break;
        }
        int fill_block = 0, top_block = 0, time = N*M*256*2, height = -1, up_block = 0, down_block = 0;
        for(int i = min+1; i<=max; i++){
            down_block += block[i-1]; 
            fill_block += down_block;
        }
        for(int i = max; i >= min ; i--){
            if( fill_block <= B+top_block  && top_block*2 + fill_block < time ){
                time = top_block*2 + fill_block;
                height = i;     
            }
            if(i==0) break;
            up_block += block[i];
            top_block += up_block; 
            fill_block -= down_block; 
            down_block -= block[i-1]; 
        }
        sb.append(time).append(" ").append(height);
        System.out.println(sb.toString());
    }
}