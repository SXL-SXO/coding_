import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, N, answer, worst_i, worst_p;
    static boolean visit[];
    static PriorityQueue<People> pQueue = new PriorityQueue<>((o1,o2)->o1.paper-o2.paper);
    static PriorityQueue<People> iQueue = new PriorityQueue<>((o1,o2)->o1.interview-o2.interview);

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            visit = new boolean[N];
            answer = 0;
            worst_i = 100001;
            worst_p = 100001;

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                People input = new People(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                iQueue.offer(input);
                pQueue.offer(input);
            }
            
            People apply_p = pQueue.peek(), apply_i = iQueue.peek();
            while(!pQueue.isEmpty()||!iQueue.isEmpty()){
                if(!pQueue.isEmpty())apply_p = pQueue.poll();
                if(!iQueue.isEmpty())apply_i = iQueue.poll();

                // System.out.println("p : "+ apply_p);
                // System.out.println("i : "+apply_i);
                if(!visit[apply_p.index] && worst_i>apply_p.interview){
                    worst_i = apply_p.interview;
                    visit[apply_p.index] = true; 
                }else if(visit[apply_p.index]) pQueue.clear();

                if(!visit[apply_i.index] && worst_p>apply_i.paper){
                    worst_p = apply_i.paper;
                    visit[apply_i.index] = true; 
                }else if(visit[apply_i.index]) iQueue.clear();
            }

            for(int i=0;i<N;i++){
                if(visit[i]) answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    static class People{
        int index,paper,interview;
        People(int index, int paper, int interview){
            this.index=index;
            this.paper=paper;
            this.interview=interview;
        }
        @Override
        public String toString() {
            return "People [index=" + index + ", paper=" + paper + ", interview=" + interview + "]";
        }    
            
    }
        
}
