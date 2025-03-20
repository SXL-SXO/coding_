import java.util.*;
import java.io.*;

public class Main
{
	static int map[][];
	static boolean dy[][], dx[][], dg[][];
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[9][9];
		dy = new boolean[9][10];
		dx = new boolean[9][10];
		dg = new boolean[9][10];

		for(int i=0; i<9; i++) {
			char input[] = br.readLine().toCharArray();
			for(int j=0; j<9; j++) {
				map[i][j] = input[j]-'0';
				if(map[i][j]==0) continue;
				
				dy[i][map[i][j]] = true;
				dx[j][map[i][j]] = true;
				dg[i/3*3+j/3][map[i][j]] = true;
			}
		}
		check(0, 0);
        
		System.out.print(sb);
	}
	static boolean check(int y, int x){
	    if(x==9) {
	        x = 0;
	        y = y+1;
    	    if(y==9) {
    	        for(int i=0;i<9;i++){
        		    for(int j=0;j<9;j++){
        		        sb.append(map[i][j]);
        		    }
        		    sb.append("\n");
        		}
        		return true;
    	    }
	    }
	    
	    
	    if(map[y][x]!=0) return check(y, x+1);
	    
	    for(int i=1;i<=9;i++){
	        if(dy[y][i] || dx[x][i] || dg[y/3*3+x/3][i]) continue;
	        
	        map[y][x] = i;
	        dy[y][map[y][x]] = true;
	        dx[x][map[y][x]] = true;
	        dg[y/3*3+x/3][map[y][x]] = true;
	        
	        if(check(y, x+1)) return true;
	        
	        dy[y][map[y][x]] = false;
	        dx[x][map[y][x]] = false;
	        dg[y/3*3+x/3][map[y][x]] = false;
	        map[y][x] = 0;
	    }
	    
	    return false;
	}
}
