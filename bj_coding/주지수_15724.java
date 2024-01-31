import java.io.*;
import java.util.*;

// 1. 냅다 더하기 했다가 틀림
// 2. Map 에 시작좌표 끝좌표 넣고 계산 -> 안곂치는 경우는 어쩔껀디
// 3. size별로 정렬해놓고, size보다 작은 놈을 돌면서 이미 구한 녀석 빼기 -> 구한게 곂치면 어킬껀디
// 4. 답 참고

public class 주지수_15724 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int people[][] = new int[N][M];
        int jujisu[][] = new int[N][M]; //0,0부터 i,j까지 총 합
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                people[i][j] = Integer.parseInt(st.nextToken());
                if(i==0 && j==0){
                    jujisu[0][0] = people[i][j];
                    continue;
                }else if(i==0) jujisu[i][j] = jujisu[i][j-1] + people[i][j];
                else if(j==0) jujisu[i][j] = jujisu[i-1][j] + people[i][j];
                else jujisu[i][j] = jujisu[i][j-1] + jujisu[i-1][j] - jujisu[i-1][j-1] + people[i][j];
            }
        }
        StringBuilder answer = new StringBuilder();
        long count = 0;

        int K = Integer.parseInt(br.readLine());
        int ran[] = new int[4]; //행, 렬, 행, 렬

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            ran[0] = Integer.parseInt(st.nextToken())-2;
            ran[1] = Integer.parseInt(st.nextToken())-2;
            ran[2] = Integer.parseInt(st.nextToken())-1;
            ran[3] = Integer.parseInt(st.nextToken())-1;
            count = jujisu[ran[2]][ran[3]];
            if(ran[0]>-1)
                count -= jujisu[ran[0]][ran[3]];
            if(ran[1]>-1)
                count -= jujisu[ran[2]][ran[1]];
            if(ran[0]>-1 && ran[1]>-1)
                count += jujisu[ran[0]][ran[1]];

            answer.append(count).append("\n");
        }
        System.out.println(answer.toString());
    }
}
