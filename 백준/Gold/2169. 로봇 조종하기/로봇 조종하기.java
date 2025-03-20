import java.util.*;
import java.io.*;
public class Main
{
	static int N, M, answer = -100000001;
	static int input[][], val[][], right[], left[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		input = new int[N][M];
		val = new int[N][M];
		right = new int[M];
		left = new int[M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(N==1&&M==1) {
		    answer = input[0][0];
		}else if(M==1){
		    answer = 0;
		    for(int i=0;i<N;i++) answer += input[i][0];
		}else{
		    val[0][0] = input[0][0];
		    for(int j=1;j<M;j++) val[0][j] = val[0][j-1] + input[0][j];
		    
		    if(N!=1) check(1);
		    else answer = val[0][M-1];
		}
		System.out.print(answer);
	}
	static void check(int y) {
	    left[0] = val[y-1][0]+input[y][0];
	    right[M-1] = val[y-1][M-1]+input[y][M-1];
	    
	    for(int j=1;j<M;j++) {
	        left[j] = Math.max(val[y-1][j], left[j-1])+input[y][j];
	        right[M-1-j] = Math.max(val[y-1][M-1-j], right[M-j])+input[y][M-1-j];
	    }
	    
	    if(y==N-1){
	        answer = left[M-1];
	        return;
	    }
	    
	    for(int j=0;j<M;j++) {
	        val[y][j] = Math.max(left[j], right[j]);
	    }
	    check(y+1);
	}
}
