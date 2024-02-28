import java.io.*;
import java.util.*;

public class B_정복자_14950 {
    static int N,M,T,count=0;
    static long answer=0;
    static List<List<Node>> city = new ArrayList<>();
    static boolean visit[];
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)-> o1.c-o2.c);
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        visit[1] = true;

        for(int i=0;i<=N;i++){
            city.add(new ArrayList<>());
        }

        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            city.get(A).add(new Node(B,C));
            city.get(B).add(new Node(A,C));
        }

        //if(N==1) {answer = 0; return;}

        for(Node n : city.get(1)){
            pqueue.offer(n);
        }
        
        while(!pqueue.isEmpty()){
            Node temp = pqueue.poll();
            if(visit[temp.v]) continue;
            visit[temp.v] = true;

            answer += (long)count*T + (long)temp.c;
            count++;
            for(Node n : city.get(temp.v)){
                pqueue.offer(n);
            }
        }
        System.out.println(answer);
    }
    static class Node{
        int v, c;
        Node(int v,int c){
            this.v=v;
            this.c=c;
        }
    }
}
