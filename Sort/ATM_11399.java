import java.io.*;
import java.util.*;

public class ATM_11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0, time = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            pqueue.offer(Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<N;i++){
            time += pqueue.poll();
            answer += time;
        }
        System.out.println(answer);
    }
}
