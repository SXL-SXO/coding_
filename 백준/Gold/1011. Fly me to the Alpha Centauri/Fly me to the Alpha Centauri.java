import java.util.*;
import java.io.*;
public class Main
{
    static int T, N;
    static int dp[] = new int[100000];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		
		long sum = 1;
		int idx = 1, count = 1, max = (int)Math.pow(2,31);
		boolean even = false;
	
		while(sum < max){
		    dp[idx++] = (int)sum;
		    sum += count;
		    
		    if(even) count++;
		    even = !even;
		}
		idx--;
		
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
		    st = new StringTokenizer(br.readLine());
		    
		    N = Math.abs(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken()));
		    
		    for(int i=idx;i>=0;i--){
		        if(dp[i]<=N) {
		            sb.append(i).append("\n");
		            break;
		        }
		    }
		}
		
		System.out.print(sb);
    }
}