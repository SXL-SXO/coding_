import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, answer;
    static int link[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            link = new int [N][N];
            answer = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    link[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N;i++){ //경유지
                for(int j=0;j<N;j++){ //시작
                    if(j==i) continue;
                    for(int k=0;k<N;k++){ //끝
                        if(link[j][i]==0||link[i][k]==0||i==k||j==k) continue;
                        
                        if(link[j][k]==0) link[j][k] = link[j][i]+link[i][k];
                        else link[j][k] = Math.min(link[j][k], link[j][i]+link[i][k]);
                    }
                }
            }
            for(int i=0;i<N;i++){ //경유지
                int count = 0;
                for(int j=0;j<N;j++){ //시작
                    count+=link[i][j];
                }
                answer = Math.min(answer, count);
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
