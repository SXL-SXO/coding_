import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static Node end = new Node(0,0), start = new Node(-1,-1);
    static char input[][];
    static boolean visit_dir[][][];
    static int visit[][];
    static int dy[] = {0, 1, 0, -1};
    static int dx[] = {1, 0, -1, 0};
    static PriorityQueue<Node> queue = new PriorityQueue<>((o1,o2)->o1.count-o2.count);
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		input = new char[N][];
		visit = new int[N][M];
		visit_dir = new boolean[N][M][4];
		
		for(int i=0;i<N;i++){
		    input[i] = br.readLine().toCharArray();
		    Arrays.fill(visit[i], N*M+1);
		    for(int j=0;j<M;j++){
		        if(input[i][j]=='C'){
		            if(start.y==-1 && start.x==-1) start = new Node(i, j);
		            else end = new Node(i, j);
		        } 
		        else if(input[i][j]=='*') visit[i][j] = -5;
		    }
		}
		
		check();
// 		for(int i=0;i<N;i++) System.out.println(Arrays.toString(visit[i]));
		System.out.print(visit[end.y][end.x]);
	}
	static void check(){
	    Node temp;
	    int ny, nx, dir;
	    
	    visit[start.y][start.x] = 0;
		for(int k=0;k<4;k++){
		    ny = start.y+dy[k];
		    nx = start.x+dx[k];
            if(ny<0 || ny>=N || nx<0 || nx>=M || input[ny][nx]=='*') continue;
            visit[ny][nx] = 0;
            queue.offer(new Node(ny, nx, 0, k));
            
		}
	    
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	       // System.out.println(temp);
	        if(temp.y == end.y && temp.x == end.x) return;
	        
	        for(int i=0;i<4;i++){
	            ny = temp.y + dy[i];
	            nx = temp.x + dx[i];
	            dir = Math.abs(temp.before-i);
	            
	            if( dir == 2 || ny<0 || ny>=N || nx<0 || nx>=M) continue;
	            else if((dir == 1||dir==3) && temp.count+1<=visit[ny][nx]) 
	                fill_blank(ny, nx, temp.count+1, i);
	            else if(dir == 0 && temp.count<=visit[ny][nx]) 
	                fill_blank(ny, nx, temp.count, i);
	        }
	        
	    }
	}
	static void fill_blank(int y, int x, int count, int before){
	    if(count==visit[y][x] && visit_dir[y][x][before]) return;
	    visit_dir[y][x][before] = true;
	    queue.offer(new Node(y, x, count, before));
        visit[y][x] = count;
	}
	static class Node{
	    int y, x, count, before;
	    Node(int y, int x){
	        this.y=y;
	        this.x=x;
	    }
	    Node(int y, int x, int count, int before){
	        this.y=y;
	        this.x=x;
	        this.count=count;
	        this.before=before;
	    }
	    @Override
	    public String toString(){
	        return this.y+" "+this.x+" "+this.count+" "+this.before;
	    }
	}
}
