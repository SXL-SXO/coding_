import java.io.*;
import java.util.*;

public class Main {
    static int N, temp, answer = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        if(N==1) {
            System.out.println(0);
            return ;
        }
        while(pq.size()>=2){
            temp = pq.poll()+pq.poll();
            answer += temp;
            pq.offer(temp);
        }
        System.out.println(answer);
    }

}
