import java.io.*;
import java.util.*;

public class Main
{
    static int N, answer = 1001001;
    static int RGB[][], dp[][][];
    static int start[][][];
	public static void main(String[] args)throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    RGB = new int[N][3];
	    dp = new int[N][3][3];
	    start = new int[N][3][3];
	    for(int a=0;a<N;a++){
	        st = new StringTokenizer(br.readLine());
	        for(int b=0;b<3;b++) RGB[a][b] = Integer.parseInt(st.nextToken());
	    }
	    
	    //dp[a][b][c]
	    //a번째 집은 b색을 칠한다 그 처음의 색은 c였다
	    
	    dp[0][0][0] = RGB[0][0];
	    dp[0][0][1] = 10001;
	    dp[0][0][2] = 10001;
	    dp[0][1][0] = 10001;
	    dp[0][1][1] = RGB[0][1];
	    dp[0][1][2] = 10001;
	    dp[0][2][0] = 10001;
	    dp[0][2][1] = 10001;
	    dp[0][2][2] = RGB[0][2];
	    	    
	    int i, j;
	    for(int a=0;a<N-1;a++){
             // b번째 색을 바르겠다
	        for(int b=0;b<3;b++){
	            // 처음색이 c인녀석들 중 b색을 발랐을때 값이 더 작은 녀석 찾기
	            i = b-1==-1 ? 2 : b-1;
	            j = b+1==3 ? 0 : b+1;
	            
	            for(int c=0;c<3;c++){
	                dp[a+1][b][c] = Math.min(dp[a][i][c], dp[a][j][c]) + RGB[a+1][b];
	            }
	        }
	    }
        for(int b=0;b<3;b++){
            for(int c=0;c<3;c++){
                if(b==c) continue;
                answer = Math.min(dp[N-1][b][c], answer);
            }
        }
        System.out.print(answer);
	}
}