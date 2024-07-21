import java.util.*;
import java.io.*;
public class Main
{
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0;i<N+M;i++){
            sb.append(pq.poll()).append(" ");
        }
        System.out.print(sb);
	}
}
