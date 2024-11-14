import java.util.*;
import java.io.*;
public class Main
{
    static int T, N;
    static int input[], sum[][], dp[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++){
		    N = Integer.parseInt(br.readLine());
		    input = new int[N];
		    
		    //시작인덱스. 포함되는 개수
		    dp = new int[N][N+1];
		    sum = new int[N][N+1];
		    
		    st = new StringTokenizer(br.readLine());
		    for(int i=0;i<N;i++){
		        sum[i][1] = input[i] = Integer.parseInt(st.nextToken());
		    }
		    
		    //개수
		    for(int i=2;i<=N;i++){
		        //시작 인덱스
		        for(int j=0;j<=N-i;j++){
		            //중간 인덱스
	                sum[j][i] = sum[j][1]+sum[j+1][i-1];
	                dp[j][i] = sum[j][i]+dp[j][1]+dp[j+1][i-1];
		            for(int k=j+2; 0<=i-(k-j) && k<N; k++){
		                dp[j][i] = Math.min(dp[j][i], sum[j][i]+dp[j][k-j]+dp[k][i-(k-j)]);
		            }
		        }
		    }
		    sb.append(dp[0][N]).append("\n");
		}
		System.out.print(sb);
	}
}
