import java.io.*;
import java.util.*;
public class 카드2_2164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            queue.offer(i);
        }
        while(true){
            if(queue.size()==1){
                System.out.println(queue.poll());
                break;
            }
            queue.poll();
            if(queue.size()==1){
                System.out.println(queue.poll());
                break;
            }
            int temp = queue.poll();
            queue.offer(temp);
        }
    }
}
