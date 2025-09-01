import java.util.*;
import java.io.*;
public class Main
{
    static int N, K, idx_in, idx_out, turn = 0, count = 0, answer = 0;
    static int input[];
    static boolean visit[];
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    input = new int[N*2];
	    visit = new boolean[N*2];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<2*N;i++) input[i] = Integer.parseInt(st.nextToken());
	    
	    turn = 1;
	    idx_in = 0;
	    idx_out = N-1;
	    while(answer==0){
	        one();
	        two();
	        three();
	       // System.out.println("| "+count+" "+answer+" "+Arrays.toString(input));
	        turn++;
	    }
	    
		System.out.println(answer);
	}
	static void three(){
	    if(answer != 0) return;
	    if(input[idx_in]>0 && !visit[idx_in]) {
	        input[idx_in]--;
	        visit[idx_in] = true;
	        queue.offer(idx_in);
	        if(input[idx_in]==0 && ++count==K) answer = turn;
	    }
	}
	static void one(){
	    idx_in = idx_in==0 ? 2*N-1 : idx_in-1;
	    idx_out = idx_out==0 ? 2*N-1 : idx_out-1;
	}
	static void two(){
	    if(answer != 0) return;
	    
	    int size = queue.size(), temp, next;
	    for(int i=0;i<size;i++){
	        temp = queue.poll();
	       // System.out.print(temp+" ");
	        next = temp+1 == 2*N ? 0 : temp+1;
	        
	        if(temp == idx_out) visit[temp] = false;
	        else if(visit[next] || input[next]==0) queue.offer(temp);
	        else if(next == idx_out) {
	            input[next]--;
	            if(input[next] == 0){
    	            if(++count == K) {
    	                answer = turn;
    	                return;
    	            }
	            }
	            visit[temp] = false;
	        }else {
	            input[next]--;
	            if(input[next] == 0){
    	            if(++count == K) {
    	                answer = turn;
    	                return;
    	            }
	            }
	            visit[next] = true;
	            visit[temp] = false;
	            queue.offer(next);
	        }
	    }
	    
	}
}
