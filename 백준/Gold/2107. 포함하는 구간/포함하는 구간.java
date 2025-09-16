import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static Node input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new Node[N];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	    }
	    Arrays.sort(input, (o1, o2) -> o2.e-o1.e);
	    
	    int count;
	    for(int i=0;i<N;i++){
	        count = 0;
	        for(int j=i+1;j<N;j++){
	            if(input[j].s>=input[i].s) count++;
	            else if(input[i].s>input[j].e) break;
	        }
	        answer = Math.max(answer, count);
	        if(answer>=N-i) break;
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
