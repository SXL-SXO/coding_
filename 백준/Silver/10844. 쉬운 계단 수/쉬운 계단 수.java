import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = 0;
    static int num[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    num = new int[N][10];
	    num[0][0] = 0; // 0으로 끝난 수
	    num[0][1] = 1; // 1로 끝난 수 
	    num[0][2] = 1; // 2로 끝난 수
	    num[0][3] = 1; // 2로 끝난 수
	    num[0][4] = 1; // 2로 끝난 수
	    num[0][5] = 1; // 2로 끝난 수
	    num[0][6] = 1; // 2로 끝난 수
	    num[0][7] = 1; // 2로 끝난 수
	    num[0][8] = 1; // 2로 끝난 수
	    num[0][9] = 1; // 2로 끝난 수
	    
	    for(int i=1;i<N;i++){
	        num[i][0] = num[i-1][1]%1_000_000_000;
	        for(int j=1;j<9;j++){
	            num[i][j] = (num[i-1][j-1] + num[i-1][j+1])%1_000_000_000;
	        }
	        num[i][9] = num[i-1][8]%1_000_000_000;
	    }
	    for(int j=0;j<10;j++){
            answer += num[N-1][j];
            answer %= 1_000_000_000;
        }
	    
		System.out.println(answer);
	}
}
