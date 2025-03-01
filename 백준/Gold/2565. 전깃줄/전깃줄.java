import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static Node input[];
    static int dp[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new Node[N];
	    dp = new int[N];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	    }
	    Arrays.sort(input, (o1,o2) -> o1.a-o2.a);
	    
	    for(int i=0;i<N;i++){
	        dp[i] = 1;
	        for(int j=i-1;j>=0; j--){
	            dp[i] = check(input[i], input[j]) ? Math.max(dp[j]+1, dp[i]) : dp[i];
	        }
	    }
	    
	    for(int d : dp) answer = Math.max(answer, d);
	    
	    System.out.print(N-answer);
	}
	static boolean check(Node m, Node n){
	    if(n.a<m.a && n.b<m.b) return true;
	    return false;
	}
	static class Node{
	    int a, b;
	    Node(int a, int b){
	        this.a=a;
	        this.b=b;
	    }
	}
}
