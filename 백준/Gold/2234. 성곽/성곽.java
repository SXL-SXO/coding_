import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, a = 0, b = 0, c = 0;
    static int d[] = {-1, -1, 1, 1};
    static int input[][], room[][], group[][];
    static boolean visit[][];
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    M = Integer.parseInt(st.nextToken());
	    N = Integer.parseInt(st.nextToken());
	    
	    input = new int[N][M];
	    room = new int[N][M];
	    group = new int[N][M];
	    visit = new boolean[N][M];
	    
	    d[1] *= M;
	    d[3] *= M;
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<M;j++){
	            input[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            if(room[i][j] == 0) {
	                a++;
	                fill(i, j, go(i, j));
	            }
	        }
	    }
	    
	    for(int i=0;i<N-1;i++){
	        for(int j=0;j<M-1;j++){
	            for(int k=2;k<4;k++){
	                if(group[i][j]!=group[i+k%2][j+(k+1)%2]) c = Math.max(c, room[i][j]+room[i+k%2][j+(k+1)%2]);
	            }
	        }
	        if(group[i][M-1]!=group[i+1][M-1]) c = Math.max(c, room[i][N-1]+room[i+1][M-1]);
	    }
	    for(int j=0;j<M-1;j++){
            if(group[N-1][j]!=group[N-1][j+1]) c = Math.max(c, room[N-1][j]+room[N-1][j+1]);
        }
        
        sb.append(a).append("\n").append(b).append("\n").append(c);
        
		System.out.println(sb);
	}
	static void fill(int y, int x, int count){
	    queue.offer(y*M+x);
	    visit[y][x] = false;
	    room[y][x] = count;
	    group[y][x] = a;
	    
	    int temp;
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        
	        for(int i=0;i<4;i++){
	            if((input[temp/M][temp%M] & (1<<i)) == 0 && visit[(temp+d[i])/M][(temp+d[i])%M]){
	                queue.offer(temp+d[i]);
	                visit[(temp+d[i])/M][(temp+d[i])%M] = false;
	                room[(temp+d[i])/M][(temp+d[i])%M] = count;
	                group[(temp+d[i])/M][(temp+d[i])%M] = a;
	            } 
	        }
	    }
	}
	static int go(int y, int x){
	    queue.offer(y*M+x);
	    visit[y][x] = true;
	    
	    int temp, res = 0;
	    while(!queue.isEmpty()){
	        res++;
	        temp = queue.poll();
	        
	        for(int i=0;i<4;i++){
	            if((input[temp/M][temp%M] & (1<<i)) == 0 && !visit[(temp+d[i])/M][(temp+d[i])%M]){
	                queue.offer(temp+d[i]);
	                visit[(temp+d[i])/M][(temp+d[i])%M] = true;
	            } 
	        }
	    }
	    
	    b = Math.max(b, res);
	    return res;
	}
}
