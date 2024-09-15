import java.io.*;
import java.util.*;
public class Main
{
    static int N, size, answer = 0;
    static PriorityQueue<Node> input = new PriorityQueue<>((o1, o2)-> o2.end-o1.end);
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            input.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        answer = input.peek().end;
        
        Node temp;
        for(int i=0;i<N;i++){
            temp = input.poll();
            answer = Math.min(temp.end, answer);
            answer -= temp.time;
        }
        answer = answer<0 ? -1 : answer;
        System.out.print(answer);
	}
	static class Node{
	    int time, end;
	    Node(int time, int end){
	        this.time = time;
	        this.end = end;
	    }
	}
}
