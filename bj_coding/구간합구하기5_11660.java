import java.io.*;
import java.util.*;

public class 구간합구하기5_11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int temp;
        int num[][] = new int[N][N]; //0,0부터 i,j까지 총 합
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                temp = Integer.parseInt(st.nextToken());
                if(i==0 && j==0){
                    num[0][0] = temp;
                    continue;
                }else if(i==0) num[i][j] = num[i][j-1] + temp;
                else if(j==0) num[i][j] = num[i-1][j] + temp;
                else num[i][j] = num[i][j-1] + num[i-1][j] - num[i-1][j-1] + temp;
            }
        }
        StringBuilder answer = new StringBuilder();
        long count = 0;
        
        int ran[] = new int[4]; //행, 렬, 행, 렬

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            ran[0] = Integer.parseInt(st.nextToken())-2;
            ran[1] = Integer.parseInt(st.nextToken())-2;
            ran[2] = Integer.parseInt(st.nextToken())-1;
            ran[3] = Integer.parseInt(st.nextToken())-1;
            count = num[ran[2]][ran[3]];
            if(ran[0]>-1)
                count -= num[ran[0]][ran[3]];
            if(ran[1]>-1)
                count -= num[ran[2]][ran[1]];
            if(ran[0]>-1 && ran[1]>-1)
                count += num[ran[0]][ran[1]];

            answer.append(count).append("\n");
        }
        System.out.println(answer.toString());
    }
}
