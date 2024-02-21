import java.io.*;
import java.util.*;

public class 연결요소의개수_11724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if(M==0) {
            System.out.println(N);
            return;
        }
        int answer = 0;
        boolean visit_node[] = new boolean[N+1];
        boolean visit_line[][] = new boolean[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            visit_line[A][B] = true;
            visit_line[B][A] = true;
        }
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i=1;i<=N;i++){
            if(visit_node[i]) continue;
            queue.offer(i);
            visit_node[i] = true;
            while(!queue.isEmpty()){
                int temp = queue.poll();
                for(int j=1;j<=N;j++){
                    if(!visit_line[j][temp] || visit_node[j]) continue;
                    queue.offer(j);
                    visit_node[j] = true;
                    visit_line[j][temp] = false;    
                    visit_line[temp][j] = false;    
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
    
}
