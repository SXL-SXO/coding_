import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, K;
    static int B[][], W[][];
    static char input[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    // WBW 형태에서 각각 틀린 경우
	    input = new char[N+1][];
	    B = new int[N+1][M+1]; 
	    W = new int[N+1][M+1];
	    
	    for(int i=1;i<=N;i++) {
	        input[i] = br.readLine().toCharArray();
	    }
	    
	    for(int i=1;i<=N;i++){
	        for(int j=1;j<=M;j++){
	            B[i][j] = B[i-1][j] + B[i][j-1] - B[i-1][j-1];
	            W[i][j] = W[i-1][j] + W[i][j-1] - W[i-1][j-1];
	            
	            if((i+j)%2 == 0 && input[i][j-1]=='B') B[i][j] ++;
	            else if((i+j)%2 == 1 && input[i][j-1]=='W') W[i][j] ++;
	        }
	       //Arrays.toString(B[i]));
	    }
	    
	    
	    int answer = K*K, val_B, val_W;
	    for(int i=1;i<=N-K+1;i++){
	        for(int j=1;j<=M-K+1;j++){
	            val_B = B[i+K-1][j+K-1]-B[i-1][j+K-1]-B[i+K-1][j-1]+B[i-1][j-1];
	            val_W = W[i+K-1][j+K-1]-W[i-1][j+K-1]-W[i+K-1][j-1]+W[i-1][j-1];
	           // System.out.println(val_W+" "+val_B);
	            answer = Math.min(answer, Math.min(K*K-val_B-val_W, val_W+val_B));
	        }
	    }
	    
		System.out.println(answer);
	}
}
