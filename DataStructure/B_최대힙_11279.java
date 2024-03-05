import java.io.*;
import java.util.*;

public class B_최대힙_11279 {
    static PriorityQueue<Integer> pqueue = new PriorityQueue<>((o1,o2)->o2-o1);
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0) pqueue.offer(x);
            else {
                if(pqueue.isEmpty()) sb.append(0).append("\n");
                else sb.append(pqueue.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}
