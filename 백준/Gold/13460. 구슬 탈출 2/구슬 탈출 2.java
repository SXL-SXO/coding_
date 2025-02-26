import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, ry, rx, by, bx, answer = 11;
    static char input[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new char[N][];
	    for(int i=0;i<N;i++) {
	        input[i] = br.readLine().toCharArray();
	        for(int j=0;j<M;j++){
	            if(input[i][j]=='R'){
	                ry = i;
	                rx = j;
	                input[i][j] = '.';
	           }else if(input[i][j]=='B'){
	                by = i;
	                bx = j;
	                input[i][j] = '.';
	           }
	        }
	    }
	    
	    for(int i=0;i<4;i++){
	        move(ry, rx, by, bx, i, 1);
	    }
	    
	    answer = answer == 11 ? -1 : answer;
		System.out.println(answer);
	}
	static void move(int ry, int rx, int by, int bx, int dir, int count){
	    if(answer<=count) return;
	    
	   // System.out.println(ry+" "+rx+" "+by+" "+bx+" "+dir+" "+count);
	    
	    int nry = ry, nrx = rx, nby = by, nbx = bx;
	    
	    while(input[nby][nbx]=='.'){
	        nby += dy[dir];
	        nbx += dx[dir];
	    }
	    if(input[nby][nbx]=='O') return;
	    nby -= dy[dir];
        nbx -= dx[dir];
        
	    while(input[nry][nrx]=='.'){
	        nry += dy[dir];
	        nrx += dx[dir];
	    }
	    if(input[nry][nrx]=='O') {
	        answer = Math.min(answer, count);
	        return;
	    }
	    nry -= dy[dir];
        nrx -= dx[dir];
        
	    
        if(nry==nby && nrx==nbx) {
            if((by<ry && dir==0) || (by>ry && dir==2)) nry -= dy[dir];
            else if((by>ry && dir==0) || (by<ry && dir==2)) nby -= dy[dir];
            
            if((bx>rx && dir==1) || (bx<rx && dir==3)) nrx -= dx[dir];
            else if((bx<rx && dir==1) || (bx>rx && dir==3)) nbx -= dx[dir];
        }
        
        
	    for(int i=0;i<4;i++){
	        if(i!=dir) move(nry, nrx, nby, nbx, i, count+1);
	    }
	}
}
