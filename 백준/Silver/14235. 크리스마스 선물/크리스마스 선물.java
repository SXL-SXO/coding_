import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->o2-o1);
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    N = Integer.parseInt(br.readLine());
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        M = Integer.parseInt(st.nextToken());
	        if(M==0){
	            if(pq.isEmpty()) sb.append("-1\n");
	            else sb.append(pq.poll()).append("\n");
	        }else{
	            for(int j=0;j<M;j++) pq.offer(Integer.parseInt(st.nextToken()));
	        }
	    }
	    System.out.print(sb);
	}
}