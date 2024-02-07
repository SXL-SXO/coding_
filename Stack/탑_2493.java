import java.io.*;
import java.util.*;

public class 탑_2493 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        int top[] = new int[N];
        for(int i=0;i<N;i++){
            top[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(0).append(" ");
        for(int i=1;i<N;i++){
            for(int j=i-1;j>-1;j--){
                if(top[i]<top[j]){
                    sb.append(j+1).append(" ");
                    break;
                }
                if(j==0) sb.append(j).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}