import java.io.*;
import java.util.*;
public class Main
{
    static int N, size, answer = 0;
    static Node term = new Node(0, 0);
    static PriorityQueue<Node> in = new PriorityQueue<>((o1, o2)-> o1.start==o2.start ? o2.end-o1.end : o1.start-o2.start );
    static PriorityQueue<Integer> out = new PriorityQueue<>((o1,o2)->o1-o2);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            
            in.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        Node temp;
        for(int i=0;i<N;i++){
            temp = in.poll();
            out.offer(temp.end);
            while(!out.isEmpty() && out.peek()<=temp.start){
                out.poll();
                // System.out.print(out.poll());
            }
            
            size = out.size();
            if(answer<size) {
                answer = size;
                term.start = temp.start;
                term.end = out.peek();
            }else if(answer== size && temp.start==term.end){
                term.end = temp.end;
            }
        }
        sb.append(answer).append("\n").append(term.start).append(" ").append(term.end);
		System.out.print(sb);
	}
	static class Node{
	    int start, end;
	    Node(int start, int end){
	        this.start = start;
	        this.end = end;
	    }
	}
}
