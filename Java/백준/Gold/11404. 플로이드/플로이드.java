import java.util.*;
import java.io.*;

public class Main
{
	static int N, M;
	static int cost[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cost = new int[N+1][N+1];
        
        for(int i=1;i<=N;i++){
            Arrays.fill(cost[i], 100_000_001);
        }
        
        int a, b, c;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], c);
        }
        
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i==j) cost[i][j] = 0;
                    else cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(cost[i][j] == 100_000_001) sb.append("0 ");
                else sb.append(cost[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}
}
