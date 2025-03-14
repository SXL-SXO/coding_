import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, answer = 0;
    static int input[];
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int idx = 0, sum = 0;
	    while(idx<N){
	        if(sum==M){
	            answer++;
	            sum += input[idx];
	            queue.offer(input[idx++]);
	        }else if(sum<M) {
	            sum += input[idx];
	            queue.offer(input[idx++]);
	        }else sum -= queue.poll();
	    }
	    
	    while(M<=sum){
	        if(sum==M) {
	            answer++;
	            break;
	        }
	        sum -= queue.poll();
	    }
	    
	    System.out.print(answer);
	}
}
