import java.util.*;
import java.io.*;

public class Main
{
	static int T, N, M, sum;
	static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
	static PriorityQueue<Integer> out = new PriorityQueue<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		T = Integer.parseInt(br.readLine());
		
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            sum = 0;
            
            pq.clear();
            out.clear();
            sb.append((N+1)/2);
            
            for(int i=1;i<=N;i++){
                if(i%10 == 1) st = new StringTokenizer(br.readLine());
                if(i%20 == 1) sb.append("\n");
                
                M = Integer.parseInt(st.nextToken());
                if(out.isEmpty() || M<=out.peek()) pq.offer(M);
                else out.offer(M);
                
                if(i%2==1) {
                    while(pq.size()<(i+1)/2){
                        pq.offer(out.poll());
                    }
                    while(pq.size()>(i+1)/2){
                        out.offer(pq.poll());
                    }
                    sb.append(pq.peek()).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}
}
