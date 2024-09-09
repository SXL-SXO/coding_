import java.util.*;
import java.io.*;

public class Main
{
    static char map[][];
    static int N, M, count = 0;
    static boolean hasKey[], visit[][];
    static Map<Integer, List<Node>> wherelock = new HashMap<>();
    static Queue<Node> queue = new ArrayDeque<>();
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static List<Node> templist;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
	    
	    hasKey = new boolean[26];
	    map = new char[N+1][M+1];
	    visit = new boolean[N+1][M+1];
	    
        for(int i = 1;i<=N; i++){
            String input = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = input.charAt(j-1);
                if(map[i][j]=='#') {
	                visit[i][j] = true;
                }else if(map[i][j]=='@') {
	                visit[i][j] = true;
	                queue.offer(new Node(i, j));
                }
            }
        }
	    for(int i=0;i<26;i++){
	        wherelock.put(i, new ArrayList<>());
	    }
	    sb.append("\n");
	    fromEndToStart();
	    System.out.print(count+sb.toString());
	}
	static void fromEndToStart(){
	    Node temp;
	    int ny, nx;
	    while(!queue.isEmpty()){
	        temp = queue.poll();
	        count++;
	        sb.append(temp.y).append(" ").append(temp.x).append("\n");
	        for(int i=0;i<4;i++){
	            ny = temp.y + dy[i];
	            nx = temp.x + dx[i];
	            if( ny>N || ny<1 || nx>M || nx<1 || visit[ny][nx]) continue;
	            visit[ny][nx] = true;
	            
	            if(map[ny][nx]=='!'){
                    count++;
	                sb.append(ny).append(" ").append(nx).append("\n");
	                return;
	            }else if( 'A'<=map[ny][nx] && map[ny][nx]<='Z' ){
	                if(hasKey[map[ny][nx]-'A']){
	                    queue.offer(new Node(ny, nx));
	                }else{
    	                templist = wherelock.get(map[ny][nx]-'A');
    	                templist.add(new Node(ny, nx));
    	                wherelock.put(map[ny][nx]-'A', templist);
	                }
	            }else if( 'a'<=map[ny][nx] && map[ny][nx]<='z' ){
	                queue.offer(new Node(ny, nx));
	                if(!hasKey[map[ny][nx]-'a']){
	                    templist = wherelock.get(map[ny][nx]-'a');
    	                for(Node n : templist){
                            queue.offer(new Node(n.y, n.x));
                        }
	                    wherelock.put(map[ny][nx]-'a', new ArrayList<>());
	                }
                    hasKey[map[ny][nx]-'a'] = true;
	            }else{
	                queue.offer(new Node(ny, nx));
	            }
	        }
	    }
	}
	static class Node{
	    int y, x;
	    Node(int y, int x){
	        this.y = y;
	        this.x = x;
	    }
	}
}
