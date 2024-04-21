import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{
    static int N,M, answer = 0;
    static Queue<Integer> queue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }
        st = new StringTokenizer(br.readLine());
        int idx, size, temp, count;
        for(int i=0;i<M;i++){
            idx = Integer.parseInt(st.nextToken());
            size = queue.size();
            count = 0;
            while(!queue.isEmpty()){
                temp = queue.poll();
                if(temp==idx){
                    answer += Math.min(count, size-count);
                    break;
                }
                queue.offer(temp);
                count++;
            }
        }
        System.out.println(answer);
    }
}