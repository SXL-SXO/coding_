import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, K;
    static boolean visit[][];
    static int dy[] = {-1, 1, -1, 1};
    static int dx[] = {-1, 1, 1, -1};
    static Queue<Node> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    visit = new boolean[2][N*M];
	    
	    int a, b;
	    for(int i=0;i<K;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken())-1;
	        b = Integer.parseInt(st.nextToken())-1;
	        visit[0][a*M+b] = true; 
	        queue.offer(new Node(a, b));
	    }
	    check();
	    if(sb.length()==0) sb.append("NO");
	    
	    System.out.print(sb);
	    
	}
	static void check(){
	    int size, add = K, ny, nx, count = 1;
	    Node temp;
	    
	    while(!queue.isEmpty()){
	        size = add;
	        add = 0;
	        for(int i=0;i<size;i++){
	            temp = queue.poll();
	            for(int j=0;j<4;j++){
	                ny = temp.y + dy[j];
	                nx = temp.x + dx[j];
	                if(ny>=N || ny<0 || nx>=M || nx<0 || visit[count][ny*M+nx]) continue;
	                visit[count][ny*M+nx] = true;
	                add++;
	                queue.offer(new Node(ny, nx));
	            }
	        }
	        count += 1;
	        count %= 2;
	    }
	    
	    for(int i=0;i<N*M;i++){
            if(!(visit[0][i]&&visit[1][i])){
                sb.append("NO");
                return;
            }
        }
        sb.append("YES");
	}
	static class Node{
	    int y, x;
	    Node(int y, int x){
	        this.y=y;
	        this.x=x;
	    }
	}
}


