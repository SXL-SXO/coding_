import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer = 0;
    static int input[][];
    static boolean visit[][], visit_temp[][];
    static Queue<Integer> queue = new ArrayDeque<>();
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    input = new int[N][M];
	    visit = new boolean[N][M];
	    visit_temp = new boolean[N][M];
	    
	    char temp[];
	    for(int i=0;i<N;i++){
	        temp = br.readLine().toCharArray();
	        for(int j=0;j<M;j++){
	            input[i][j] = temp[j]-'0';
	        }
	    }
	    
	    
	    // j보다 작은 녀석들을 전부 골라냈을때, 얘네가 벽에 안닿으면 성공 
	    for(int j=9;j>1;j--){
	        for(int i=0;i<N;i++) visit_temp[i] = Arrays.copyOf(visit[i], M);
	    
	        for(int a=1;a<N-1;a++){
	            for(int b=1;b<M-1;b++){
	                if(!visit[a][b] && !visit_temp[a][b] && input[a][b]<j) make(a, b, j);
	            }
	        }
	    }
	    
		System.out.println(answer);
	}
	static void make(int a, int b, int num){
	    int temp, ny, nx, sum = 0;
	    boolean res = true;
	    
	    visit_temp[a][b] = true;
	    queue.clear();
	    queue.offer(a*M+b);
	    sum = num-input[a][b];
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        for(int i=0;i<4;i++){
	            ny = temp/M+dy[i];
	            nx = temp%M+dx[i];
	            
	            if(ny<0 || ny>=N || nx<0 || nx>=M || visit[ny][nx] || visit_temp[ny][nx] || input[ny][nx]>=num) continue;
	            if(ny == 0 || ny == N-1 || nx == 0 || nx == M-1) res = false;
	            visit_temp[ny][nx] = true;
	            queue.offer(ny*M+nx);
	            sum += num-input[ny][nx];
	        }
	    }
	    if(!res) return;
	    
	    answer += sum;
	   // System.out.println(num+" "+answer);
	    
	    visit[a][b] = true;
	    queue.offer(a*M+b);
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        for(int i=0;i<4;i++){
	            ny = temp/M+dy[i];
	            nx = temp%M+dx[i];
	            
	            if(ny<0 || ny>=N || nx<0 || nx>=M || visit[ny][nx] || input[ny][nx]>=num) continue;
	            visit[ny][nx] = true;
	            queue.offer(ny*M+nx);
	        }
	    }
	}
}
