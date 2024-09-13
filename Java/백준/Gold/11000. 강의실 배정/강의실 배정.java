import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 1;
    static PriorityQueue<Node> input = new PriorityQueue<>((o1,o2)-> (o1.s==o2.s? o1.e-o2.e :o1.s-o2.s));
    static PriorityQueue<Integer> end = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
	    }
	    
	    Node temp;
	    for(int i=0;i<N;i++){
	        temp = input.poll();
	        end.offer(temp.e);
	        while(!end.isEmpty() && temp.s>=end.peek()){
	            end.poll();    
	        }
	        answer = Math.max(answer, end.size());
	    }
	    
	    
		System.out.println(answer);
	}
	static class Node{
	    int s, e;
	    Node(int s, int e){
	        this.s = s;
	        this.e = e;
	    }
	}
}
