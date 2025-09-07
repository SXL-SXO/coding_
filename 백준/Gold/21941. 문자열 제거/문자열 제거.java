import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, answer = 0;
    static Node point[];
    static char input[];
    static int dp[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    N = input.length;
	    dp = new int[N+1];
	    
	    M = Integer.parseInt(br.readLine());
	    point = new Node[M];
	    
	    for(int i=0;i<M;i++){
	        point[i] = new Node(br.readLine().split(" "));
 	    }
 	    
 	    for(int i=1;i<=N;i++){
 	        dp[i] = dp[i-1]+1;
 	        for(int j=0;j<M;j++){
 	            dp[i] = check(point[j].c, i) ? Math.max(dp[i], dp[i-point[j].c.length]+point[j].p) : dp[i];
 	        }
 	    }
 	    
 	    System.out.print(dp[N]);
	}
	static boolean check(char p[], int idx){
	    int len = p.length;
	    if(idx-len<0) return false;
	    
	    for(int i=1;i<=len;i++){
	        if(input[idx-i] != p[len-i]) return false;
	    }
	    return true;
	}
	static class Node{
	    char c[];
	    int p;
	    Node(String s[]){
	        c = s[0].toCharArray();
	        p = Integer.parseInt(s[1]);
	    }
	}
}
