import java.util.*;
import java.io.*;

public class Main
{
	static int N, K, answer;
	static int input[][];
	static List<Integer> lis = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
        input = new int[N][N];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            for(int j=0;j<N;j++) input[i][j] = Integer.parseInt(st.nextToken());
        }
        
        answer = make(0, 0, 0, 0, 0);
        
        System.out.print(answer);
	}
	static int make(int idx, int count_a, int count_b, int A, int B){
	    if(count_a > N/2 || count_b > N/2) return 10000000;
	    if(idx == N){
	        int sum_A = 0, sum_B = 0;
	        for(int i=0;i<N;i++){
	            for(int j=i+1;j<N;j++){
	                if((A&(1<<i))!=0 && (A&(1<<j))!=0) {
	                    sum_A += input[i][j] + input[j][i];
	                }
	                if((B&(1<<i))!=0 && (B&(1<<j))!=0) {
	                    sum_B += input[i][j] + input[j][i];
	                }
	            }
	        }
	        return Math.abs(sum_A-sum_B);
	    }
	    
	    return Math.min(make(idx+1, count_a+1, count_b, A|(1<<idx), B), make(idx+1, count_a, count_b+1, A, B|(1<<idx)));
	}
}
