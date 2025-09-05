import java.util.*;
import java.io.*;
public class Main
{
    static int a, b, c;
    static boolean visit[][][] = new boolean[22][22][22];
    static int dp[][][] = new int[22][22][22];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    dp[0][0][0] = 1;
	    visit[0][0][0] = true;
	    
	    while(true){
	        st = new StringTokenizer(br.readLine());
	        
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        
	        if(a==-1 && b==-1 && c==-1) break;
	        sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a, b, c)).append("\n");
	    }
	    System.out.print(sb.toString());
	}
	static int w(int a, int b, int c){
	     a = a < 0 ? 0 : a > 20 ? 21 : a;
	     b = b < 0 ? 0 : b > 20 ? 21 : b;
	     c = c < 0 ? 0 : c > 20 ? 21 : c;
	     
	     if(visit[a][b][c]) return dp[a][b][c];
	     visit[a][b][c] = true;
	     
	     if(a==0 || b==0 || c==0) return dp[a][b][c] = 1;
	     else if(a==21 || b==21 || c==21) return dp[a][b][c] = 1048576;
	     else if(a<b && b<c) return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
	     else return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
}
