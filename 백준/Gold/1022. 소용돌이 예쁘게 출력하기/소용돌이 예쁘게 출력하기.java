import java.util.*;
import java.io.*;

public class Main
{
    static int y1, x1, y2, x2, N;
    static int input[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, -1, 0, 1};
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    y1 = Integer.parseInt(st.nextToken());
	    x1 = Integer.parseInt(st.nextToken());
	    y2 = Integer.parseInt(st.nextToken());
	    x2 = Integer.parseInt(st.nextToken());
	    
	    N = Math.max(Math.max(Math.abs(y1), Math.abs(x1)), Math.max(Math.abs(y2), Math.abs(x2)));
	    
	    input = new int[y2-y1+1][x2-x1+1];
	    
	    if( y1<=0 && 0<=y2 && x1<=0 && 0<=x2 ) input[-y1][-x1] = 1;
	    
	    int ny = 1, nx = 1, value = 2, max = 0, len;
	    for(int i=1;i<=N;i++){
	        for(int j=0;j<4;){
	            ny += dy[j];
	            nx += dx[j];
	            
	            if( y1<=ny && ny<=y2 && x1<=nx && nx<=x2 ) {
	                input[ny-y1][nx-x1] = value;
	                max = value;
	            }
	            value++;
	            if(ny == -dy[j]*i || ny == dy[j]*i || nx == dx[j]*i || nx == -dx[j]*i ) j++;
	        }
	        ny+=1;
	        nx+=1;
	    }

	    len = (int)Math.log10(max);
	    
	   // System.out.println(N);
	   // for(int i=0;i<N*2+1;i++){
	   //     System.out.println(Arrays.toString(input[i]));
	   // }
	    for(int a = 0; a <= y2-y1 ; a++){
	        for(int b = 0; b <= x2-x1; b++){
	            for(int c = (int)Math.log10(input[a][b]); c<len; c++) sb.append(" ");
	            sb.append(input[a][b]).append(" ");
	        }
	        sb.append("\n");
	    }
	    
	    System.out.print(sb);
	}
}
