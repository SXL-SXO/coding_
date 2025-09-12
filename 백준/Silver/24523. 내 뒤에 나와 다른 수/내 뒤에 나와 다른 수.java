import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int input[], answer[];
    static Stack<Node> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    input = new int[N];
	    answer = new int[N];
	    for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
	    
	    int before_idx = N;
	    answer[N-1] = -1;
	    
	    for(int i=N-2;i>=0;i--){
	        if(input[before_idx-1] == input[i]) {
	            answer[i] = answer[before_idx-1];
	            before_idx = i+1;
	        }else {
	            answer[i] = before_idx;
	            before_idx = i+1;
	        }
	    }
	    for(int i=0;i<N;i++) sb.append(answer[i]).append(" ");
	    System.out.print(sb);
	}
	static class Node{
	    int idx, val;
	    Node(int idx, int val){
	        this.idx = idx;
	        this.val = val;
	    }
	}
}
