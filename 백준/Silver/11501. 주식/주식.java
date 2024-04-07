import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static Long answer;
    static int[] input;
    static boolean[] visited;
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)->o2.v==o1.v ? o1.idx-o2.idx: o2.v-o1.v);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            answer = 0L;
            input = new int[N];
            visited = new boolean[N];
            for(int i=0;i<N;i++){
                input[i] = Integer.parseInt(st.nextToken());
                pqueue.offer(new Node(i, input[i]));
            }
            Node before = new Node(-1, t);
            while(!pqueue.isEmpty()){
                Node temp = pqueue.poll();
                if (visited[temp.idx]) continue;
                visited[temp.idx] = true;
                for(int i=before.idx+1;i<temp.idx;i++){
                    if (visited[i]) continue;
                    if (input[i]>temp.v) continue;
                    answer += temp.v-input[i];
                    visited[i]=true;
                }
                before = temp;
            }
           sb.append(answer).append("\n");        
        }
        System.out.println(sb);

    }
    static class Node{
        int v, idx;
        Node(int idx, int v){
            this.v = v;
            this.idx = idx;
        }
    }
}
