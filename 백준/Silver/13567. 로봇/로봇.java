import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, dir = 0;
    static int dy[] = {0, -1, 0, 1};
    static int dx[] = {1, 0, -1, 0};
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int ny = 0, nx = 0, d, m;
		for(int i=0;i<M;i++){
		    st = new StringTokenizer(br.readLine());
		
		    if(st.nextToken().equals("MOVE")){
		        m = Integer.parseInt(st.nextToken());
		        
		        ny += dy[dir]*m;
		        nx += dx[dir]*m;
		        if(ny>N || ny<0 || nx>N || nx<0) {
		            sb.append(-1);
		            break;
		        }
		    }else{
		        d = Integer.parseInt(st.nextToken());
		        
		        if(d==0) dir+=3;
		        else dir+=1;
		        
		        dir%=4;
		    }
		}
		if(sb.length()==0) sb.append(nx).append(" ").append(ny);
		System.out.print(sb);
	}
}
