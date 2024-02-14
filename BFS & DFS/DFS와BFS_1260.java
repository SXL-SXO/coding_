import java.io.*;
import java.util.*;

public class DFS와BFS_1260 {
    static int N,M,V;
    static StringBuilder sb = new StringBuilder ();
    static int input[][];
    static boolean visit[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        input = new int[M][2];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            input[i][0] = Math.min(min,max);
            input[i][1] = Math.max(min,max);
        }

        Arrays.sort(input, (o1,o2) -> o1[0]==o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);

        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        
        visit = new boolean[N+1];
        bfs();
        System.out.println(sb.toString());
    }
    static void dfs(int Idx){
        visit[Idx] = true;
        sb.append(Idx).append(" ");
        for(int i=0;i<M;i++){
            if(input[i][0]==Idx && !visit[input[i][1]]) 
                dfs(input[i][1]);
            else if(input[i][1]==Idx && !visit[input[i][0]])
                dfs(input[i][0]);
        }
    }
    static void bfs(){
        Deque<Integer> queue = new ArrayDeque<>();
        int start = V;
        visit[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            start = queue.poll();
            sb.append(start).append(" ");
            for(int i=0;i<M;i++){
                if(input[i][0]==start && !visit[input[i][1]]) {
                    queue.offer(input[i][1]);
                    visit[input[i][1]] = true;
                }else if(input[i][1]==start && !visit[input[i][0]]){
                    queue.offer(input[i][0]);
                    visit[input[i][0]] = true;
                }
            }
        }
    }
}
