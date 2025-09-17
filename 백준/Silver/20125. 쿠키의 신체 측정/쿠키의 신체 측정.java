import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static char input[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    input = new char[N][];
	    for(int i=0;i<N;i++){
	        input[i] = br.readLine().toCharArray();
	    }
	    
	    int temp;
	    total : for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(input[i][j] == '*') {
	                sb.append(i+2).append(" ").append(j+1).append("\n");
	                sb.append(go(3, i+1, j-1)).append(" ").append(go(1, i+1, j+1)).append(" ");
	                
	                temp = go(2, i+2, j);
	                sb.append(temp).append(" ").append(go(2, i+temp+2, j-1)).append(" ").append(go(2, i+temp+2, j+1));
	                break total;
	            }
	        }
	    }
	    System.out.print(sb);
	}
	static int go(int dir, int y, int x){
	    int ny = y, nx = x, count = 0;
	    while(ny<N && ny>=0 && nx<N && nx>=0 && input[ny][nx]=='*'){
	        count++;
	        
	        ny += dy[dir];
	        nx += dx[dir];
	    }
	    return count;
	}
}
