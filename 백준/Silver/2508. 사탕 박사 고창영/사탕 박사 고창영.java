import java.util.*;
import java.io.*;

public class Main
{
    static char map[][];
    static int T, R, C, answer = 0;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    T = Integer.parseInt(br.readLine());
	    
	    for(int t=0;t<T;t++){
	        br.readLine();
	        st = new StringTokenizer(br.readLine());
	        answer = 0;
	        R = Integer.parseInt(st.nextToken());
	        C = Integer.parseInt(st.nextToken());
	        
	        map = new char[R][];
	        for(int i = 0;i<R; i++){
	            map[i] = br.readLine().toCharArray();
	        }
	        
	        for(int i=0;i<R;i++){
	            for(int j=0;j<C;j++){
	                if(map[i][j]=='o'){
	                    if(i>=1 && map[i-1][j]=='v' && i<R-1 && map[i+1][j]=='^') answer++;
	                    else if(j>=1 && map[i][j-1]=='>' && j<C-1 && map[i][j+1]=='<') answer++;
	                }
	            }
	        }
	        sb.append(answer).append("\n");
	    }
	    System.out.print(sb);
	}
}
