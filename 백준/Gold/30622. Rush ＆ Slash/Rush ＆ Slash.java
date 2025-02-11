import java.util.*;
import java.io.*;

public class Main
{
    // 잡초를 좌표상에 표시
    // 연결되는 잡초들을 표시
    // queue에 넣어서 제일 마지막에 나오는 녀석을 제외하고 answer+=거리*2
    // 마지막은 거리
    static long answer = 0L;
    static int N, count = 0, min_y = 0, max_y = 0, min_x = 0, max_x = 0;
    static Map<Node, Integer> map = new HashMap<>();
    static Queue<Node> queue = new ArrayDeque<>();
    static Node input[];
    static int dis[];
    static int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1}, dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		input = new Node[N];
		for(int i=0;i<N;i++) {
		    st = new StringTokenizer(br.readLine());
		    
		    input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		    map.put(input[i], N+1);
		
		    min_y = Math.min(min_y, input[i].y);
		    max_y = Math.max(max_y, input[i].y);
		    min_x = Math.min(min_x, input[i].x);
		    max_x = Math.max(max_x, input[i].x);
		}
		
		// 각 연결된 잡초 체크
		dis = new int[N+1];
		for(Node n : input){
		    if(map.getOrDefault(n, 0) == N+1) link(n);
		}
		
		Arrays.sort(dis);
		for(int i=0;i<N;i++) answer += (long)dis[i]*2;
		answer += (long)dis[N];
		
// 		for(int i=0;i<N;i++){
// 		    System.out.print(map.get(input[i])+" ");
// 		}
// 		System.out.println(Arrays.toString(dis));
		
		System.out.println(answer);
	}
	static void link(Node n){
	    // 연결된 잡초의 최단거리
	    dis[++count] = Math.abs(n.y)+Math.abs(n.x);
	    queue.offer(n);
	    
	    Node temp;
	    int ny, nx;
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	       // System.out.println("queue : "+temp.y+" "+temp.x);
	        for(int i=0; i<8; i++){
	            ny = temp.y+dy[i];
	            nx = temp.x+dx[i];
	            
	            if( ny<min_y || ny>max_y || nx<min_x || nx>max_x || map.getOrDefault(new Node(ny, nx), 0) != N+1 ) continue;
	            
	            dis[count] = Math.min(dis[count], Math.abs(ny)+Math.abs(nx));
	            map.put(new Node(ny, nx), count);
	            queue.offer(new Node(ny, nx));
	        }
	    }
	}
	static class Node{
	    int y, x;
	    Node(int y, int x){
	        this.y=y;
	        this.x=x;
	    }
	    
	    public boolean equals(Object o) {
	        if(this == o) return true;
	        if(o == null || getClass() != o.getClass()) return false;
	        
	        Node n = (Node) o;
	        return y == n.y && x == n.x;
 	    }
	    public int hashCode() {
            return Objects.hash(y, x);
        }
	}
}
