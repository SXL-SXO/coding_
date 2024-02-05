import java.io.*;
import java.util.*;

public class 회사에있는사람_7785 {
    public static void main(String[] args) throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>((o1,o2) -> o2-o1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(st.nextToken().equals("leave"))
                queue.remove(name);
            else
                queue.offer(name);
        }
    }
}
