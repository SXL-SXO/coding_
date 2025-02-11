import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static boolean visit[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        visit = new boolean[N+1][N+1];
        
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                visit[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
            visit[i][i] = true;
        }
        
		for(int k=1;k<=N;k++){
		    for(int i=1;i<=N;i++){
		        for(int j=1;j<=N;j++){
		            visit[i][j] = visit[i][j]|(visit[i][k] & visit[k][j]);
		        }
		    }
		}
		
		st = new StringTokenizer(br.readLine());
		int start, end = Integer.parseInt(st.nextToken());
		for(int i=1;i<M;i++){
		    start = end;
		    end = Integer.parseInt(st.nextToken());
		    if(!visit[start][end]) {
		        sb.append("NO");
		        break;
		    }
		}
		if(sb.length()==0) sb.append("YES");
		
		System.out.println(sb);
	}
}

