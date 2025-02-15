import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, total = 1;
    static char input[][];
    static int answer[][], map[][];
    static boolean visit[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int check[] = new int [4];
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new char[N][];
	    answer = new int[N][M];
	    map = new int[N][M];
	    visit = new boolean[N][M];
	    
	    for(int i=0;i<N;i++){
	        input[i] = br.readLine().toCharArray();
	    }
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            if(input[i][j] == '0' && !visit[i][j]) blank_one(i, j);
	        }
	    }
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            if(input[i][j] == '1') answer[i][j] = blank_zero(i, j);
	        }
	    }
	   // for(int i=0;i<N;i++){
	   //     for(int j=0;j<M;j++){
	   //        System.out.print(map[i][j]+" ");
	   //     }
	   //     System.out.println("");
	   // }
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	           sb.append(answer[i][j]);
	        }
	        sb.append("\n");
	    }
	    
	    System.out.print(sb);
	}
	static int blank_zero(int a, int b){
	    int ny, nx, count = 1;
	    Arrays.fill(check, 0);
	    
	    for(int i=0;i<4;i++){
	        ny = a + dy[i];
	        nx = b + dx[i];
	        if( ny>=N || ny<0 || nx>=M || nx<0 ) continue;
	        
	        check[i] = map[ny][nx]/100;
	        for(int j=0;j<i;j++){
	            if( check[j] == check[i] ) {
	                check[i] = 0;
	                break;
	            }
	        }
	        if( check[i] != 0) count+= map[ny][nx];
	        
	    }
	    return count%10;
	}
	static void blank_one(int a, int b){
        int y, x, ny, nx, temp, count = 1;
	    
	    visit[a][b] = true;
	    queue.offer(a*M+b);
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        y = temp/M;
	        x = temp%M;
    	    for(int i=0;i<4;i++){
    	        ny = y + dy[i];
    	        nx = x + dx[i];
    	        if( ny>=N || ny<0 || nx>=M || nx<0 || input[ny][nx]!='0' || visit[ny][nx] ) continue;
    	        count++;
    	        visit[ny][nx] = true;
    	        queue.offer(ny*M+nx);
    	    }
	    }
	    
	    map[a][b] = total*100 + count%10;
	    queue.offer(a*M+b);
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        y = temp/M;
	        x = temp%M;
    	    for(int i=0;i<4;i++){
    	        ny = y + dy[i];
    	        nx = x + dx[i];
    	        if( ny>=N || ny<0 || nx>=M || nx<0 || !visit[ny][nx] || map[ny][nx]!=0 ) continue;
    	        map[ny][nx] = map[a][b];
    	        queue.offer(ny*M+nx);
    	    }
	    }
	    
	    total++;
	}
}
