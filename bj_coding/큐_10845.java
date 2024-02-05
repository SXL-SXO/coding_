import java.io.*;
import java.util.*;

public class 큐_10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            switch(type){
                case "push" : queue.offer(Integer.parseInt(st.nextToken())); break;
                case "front" : sb.append(queue.peek()).append("\n"); break;
                case "back" : sb.append(queue.getLast()).append("\n"); break;
                case "size" : sb.append(queue.size()).append("\n"); break;
                case "empty" : sb.append(queue.isEmpty() ? 1 : 0).append("\n"); break;
                case "pop" : sb.append(queue.isEmpty()? -1 :queue.poll()).append("\n"); break;
            }
        }
        System.out.println(sb.toString());
    }
}
