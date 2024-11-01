import java.util.*;
import java.io.*;

public class Main
{
	static long answer = 0L, kind = 10L;
	static int N;
	static boolean start[], check[];
	static long num[];
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->(o1.n < o2.n ? -1 : 1));
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		check = new boolean[10];
		start = new boolean[10];
		num = new long[10];
	
		char input[];

		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			input = br.readLine().toCharArray();
			start[input[0]-'A'] = true;
			for(int j=0; j<input.length; j++) {
				num[input[input.length-1-j]-'A'] += (long)Math.pow(10, j);
			}
		}

		for(int i=0; i<10; i++) {
			if(num[i]==0L) {
			    check[i] = true;
			    kind--;
			}else if(!start[i]) {
				check[i] = true;
				pq.offer(new Node(num[i], i));
			}
		}

        Node temp ;
        if(!pq.isEmpty() && kind==10L){
            temp = pq.poll();
		    answer += num[temp.i] * (10L-kind--);
        }

		for(int i=0; i<10; i++) {
			if(!check[i]) pq.offer(new Node(num[i], i));
		}
		
		while(!pq.isEmpty()) {
			temp = pq.poll();
			answer += num[temp.i] * (10L-kind--);
		}
		
		System.out.println(answer);
	}
	static class Node {
		long n;
		int i;
		Node(long n, int i) {
			this.n = n;
			this.i = i;
		}
	}
}
