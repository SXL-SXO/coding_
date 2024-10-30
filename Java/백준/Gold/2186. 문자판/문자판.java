import java.util.*;
import java.io.*;

public class Main
{
    static char input[][], word[];
    static int N, M, K, W, answer = 0;
    static int dp[][][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    
    static Map<Integer, List<Node>> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<26;i++){
	        map.put(i, new ArrayList<>());
	    }
	    
	    List<Node> list;
	    input = new char[N][];
	    for(int i=0;i<N;i++){
	        input[i] = br.readLine().toCharArray();
	        for(int j=0;j<M;j++){
	            list = map.get(input[i][j]-'A');
	            list.add(new Node(i, j));
	        }
	    }
	    
	    word = br.readLine().toCharArray();
	    W = word.length;
	    dp = new int[N][M][W];
	    
	    for(Node n : map.get(word[0]-'A')){
	        dp[n.y][n.x][0] = 1;
	    }
	    
	    int ny, nx;
	    for(int i=0;i<W-1;i++){
	        for(Node n : map.get(word[i]-'A')){
	            for(int k=0;k<4;k++){
	                ny = n.y;
	                nx = n.x;
    	            for(int j=0;j<K;j++){
    	                ny += dy[k];
    	                nx += dx[k];
        
    	                if(ny<0 || ny>=N || nx<0 || nx>=M) break;
    	                else if(input[ny][nx]==word[i+1]){
    	                    dp[ny][nx][i+1] += dp[n.y][n.x][i];
    	                }
    	            }
    	        }
	        }
	    }
	    for(Node n : map.get(word[W-1]-'A')){
            answer += dp[n.y][n.x][W-1];
        }
		System.out.println(answer);
	}
	static class Node{
	    int y, x;
	    Node(int y, int x){
	        this.y = y;
	        this.x = x;
	    }
	}
}
