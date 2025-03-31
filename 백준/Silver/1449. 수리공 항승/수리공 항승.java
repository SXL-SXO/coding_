import java.util.*;
import java.io.*;
public class Main
{
    static int N, L;
    static int input[], dp[];
    static Stack<Character> stack = new Stack<>(), temp = new Stack<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    L = Integer.parseInt(st.nextToken());
	    input = new int[N];
	    dp = new int[N+1];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(input);
	    Arrays.fill(dp, 1001);
	    dp[N] = 0;
	    dp[N-1] = 1;
	    
	    for(int i=N-2;i>=0;i--){
	        for(int j=i+1;j<N;j++){
	            if(input[j]-input[i]<L) dp[i] = Math.min(dp[j+1]+1, dp[i]);
	            else break;
	        }
	        if(dp[i]==1001) dp[i] = Math.min(dp[i], dp[i+1]+1);
	    }
	    
		System.out.print(dp[0]);
	}
	
}
