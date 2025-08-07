import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    static int N, answer = 0;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> (o2.l-o1.l));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int start, end;
        Node temp = pq.poll();
        start = temp.w;
        end = temp.w;
        answer = temp.l;

        while(!pq.isEmpty()){
            temp = pq.poll();
            if(temp.w<start) {
                answer += (start-temp.w)*temp.l;
                start = temp.w;
            }else if(temp.w>end){
                answer += (temp.w-end)*temp.l;
                end = temp.w;
            }
        }
        System.out.println(answer);
    }
    static class Node{
        int w, l;
        Node(int w, int l){
            this.w = w;
            this.l = l;
        }
    }
}