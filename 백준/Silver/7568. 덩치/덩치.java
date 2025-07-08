import java.io.*;
import java.util.*;

public class Main{
    static int N, MAX = 40000;
    static int bigger[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        int N = Integer.parseInt(br.readLine());
       
        bigger = new int[N][2];
        
        for(int j=0;j<N;j++){
            st =new StringTokenizer(br.readLine());
            for(int i=0;i<2;i++){
                bigger[j][i]=Integer.parseInt(st.nextToken());        
            }
        }
    
        int same=1, bigman=0;
        for(int a=0;a<N;a++){
            bigman=0;
            for(int b=0;b<N;b++){
                if (bigger[a][0]<bigger[b][0]&&bigger[a][1]<bigger[b][1])
                    bigman+=1;
            }
            sb.append(bigman+1).append(" ");
        }
        System.out.print(sb);
    }
}