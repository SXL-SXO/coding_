import java.util.*;
import java.io.*;

class 파리퇴치
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
        	StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int pari[][] = new int[N+1][N+1];
            int answer = Integer.MAX_VALUE;
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    pari[i][j]=-pari[i-1][j-1]+pari[i-1][j]+pari[i][j-1]+Integer.parseInt(st.nextToken());
                }
            }
            for(int i=M;i<=N;i++){
                for(int j=M;j<=N;j++){
                    answer = Math.min( answer, pari[i][j]-pari[i-M][j]-pari[i][j-M]+pari[i-M][j-M]);
                }
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
        System.out.print(sb);
	}
}