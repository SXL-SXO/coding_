import java.util.*;
import java.io.*;
public class Main {
    static int N, M, answer = 0;
    static boolean visit[];
    static Queue<Integer> queue = new ArrayDeque<>();
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(A).add(B);
            list.get(B).add(A);
        }

        bfs();
        System.out.println(answer);
    }
    static void bfs(){
        visit = new boolean[N+1];

        queue.offer(1);
        visit[1] = true;

        for(int i=0;i<2;i++){
            int size = queue.size();
            for(int j=0;j<size;j++){
                int temp = queue.poll();
                for(int l : list.get(temp)){
                    if(visit[l]) continue;
                    visit[l] = true;
                    answer++;
                    queue.offer(l);
                }
            }
        }
    }
}
