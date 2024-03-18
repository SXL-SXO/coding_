import java.io.*;
import java.util.*;

public class B_그래프의줄기_24461 {
    static int N;
    static int node[];
    static boolean visit[];
    static List<List<Integer>> link = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        node = new int[N];
        visit = new boolean[N];
        for(int i=0;i<N;i++){
            link.add(new ArrayList<>());
        }
        
        int A, B;
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            node[A]++;
            node[B]++;
            link.get(A).add(B);
            link.get(B).add(A);
        }

        for(int i=0;i<N;i++){
            if(node[i]!=1) continue;
            node[i]--;
            queue.offer(i);
        }

        TopologicalSort();

        System.out.println(sb.toString());
    }
    static void TopologicalSort(){
        int size, temp;
        while(true){
            size = queue.size();
            if(size <= 2) break;
            for(int i=0;i<size;i++){
                temp = queue.poll();
                if(visit[temp]) continue;

                for(int j : link.get(temp)){
                    if(visit[j]) continue;
                    node[j]--;
                    if(node[j]==0) queue.offer(j);
                }
                visit[temp] = true;
            }
        }
        for(int i=0;i<N;i++){
            if(!visit[i]) sb.append(i).append(" ");
        }
    }
}
