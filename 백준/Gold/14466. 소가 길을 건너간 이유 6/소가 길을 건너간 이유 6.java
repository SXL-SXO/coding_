import java.util.*;
import java.io.*;

public class Main
{
	static int N, K, R, answer = 0;
	static int input[][];
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static int cow[][];
	static boolean road_ga[][], road_se[][], visit[][];
	static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    R = Integer.parseInt(st.nextToken());
	    
	    road_ga = new boolean[N][N-1];
	    road_se = new boolean[N-1][N];
	    cow = new int[N][N];
	    visit = new boolean[N][N];
	    input = new int[K+1][2];
	    
	    int sy, sx, ey, ex;
	    for(int i=0;i<R;i++){
	        st = new StringTokenizer(br.readLine());
	        
	        sy = Integer.parseInt(st.nextToken())-1;
	        sx = Integer.parseInt(st.nextToken())-1;
	        ey = Integer.parseInt(st.nextToken())-1;
	        ex = Integer.parseInt(st.nextToken())-1;
	        
	        if(sy==ey) {
    	        for(int b = Math.min(sx, ex); b<Math.max(sx, ex); b++){
	                road_ga[sy][b] = true;
    	        }
	        }else {
	            for(int a = Math.min(sy, ey); a<Math.max(sy, ey); a++){
	                road_se[a][sx] = true;
	            }
	        }
	    }
	   // for(int i=0;i<N;i++ ){
	   //         System.out.println(Arrays.toString(road_ga[i]));
	   // }
	   // for(int i=0;i<N-1;i++ ){
	   //         System.out.println(Arrays.toString(road_se[i]));
	   // }
	    
	    for(int i=1;i<=K;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i][0] = Integer.parseInt(st.nextToken())-1;
	        input[i][1] = Integer.parseInt(st.nextToken())-1;
	        cow[input[i][0]][input[i][1]] = i+1;
	    }
	    
	    for(int i=1;i<K;i++){
	        answer += bfs(i);
	       // System.out.println(i+" "+answer);
	    }
	    
	    System.out.print(answer);
    }
    static int bfs(int idx){
        queue.offer(input[idx][0]*N+input[idx][1]);
        
        for(int i=0;i<N;i++){
            Arrays.fill(visit[i], false);
        }
        visit[input[idx][0]][input[idx][1]] = true;
        
        int temp, ny, nx, count = 0;
        while(!queue.isEmpty()){
            temp = queue.poll();
            // System.out.println(idx+" "+temp);
            
            for(int i=0;i<4;i++){
                ny = temp/N + dy[i];
                nx = temp%N + dx[i];
                
                if(ny<0 || ny>=N || nx<0 || nx>=N || visit[ny][nx]) continue;
                else if(i==0 && road_se[ny][nx]) continue;
                else if(i==2 && road_se[temp/N][nx]) continue;
                else if(i==1 && road_ga[ny][temp%N]) continue;
                else if(i==3 && road_ga[ny][nx]) continue;
                
                if(cow[ny][nx] > idx) count++;
                
                visit[ny][nx] = true;
                queue.offer(ny*N+nx);
            }
        }
        return K-idx-count;
    }
}
