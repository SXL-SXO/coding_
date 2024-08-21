import java.util.*;
import java.io.*;
public class Main
{
	static int N, M;
	static char map[][];
	static int visit[][];
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	static Map<Character, Integer> dir = new HashMap<>();
	static Map<Integer, List<Integer>> link = new HashMap<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visit = new int[N][M];
		for(int i=0;i<N;i++){
		    map[i] = br.readLine().toCharArray();
		    Arrays.fill(visit[i], -1);
		}
		
		dir.put('U', 0);
		dir.put('R', 1);
		dir.put('D', 2);
		dir.put('L', 3);
		
		for(int i=0;i<N;i++){
		    for(int j=0;j<M;j++){
		        if(visit[i][j]==-1) check(i, j);
		    }
		}
// 		for(int key: link.keySet()){
// 		    System.out.println("key : "+key+", "+link.get(key).toString());
// 		}
		System.out.print(link.size());
	}
	static void check(int a, int b){
	    List<Integer> list = new ArrayList<>();
	    
	    int ny, nx, y, x;
	    ny = y = a;
	    nx = x = b;
	    visit[ny][nx] = -111111;
	    list.add(ny*M+nx);
	    
	    while(true){
	        ny = y + dy[dir.get(map[y][x])];
	        nx = x + dx[dir.get(map[y][x])];
	        
	        if(ny>=N||ny<0||nx>=M||nx<0||visit[ny][nx]==-111111) {
	            visit[y][x] = y*M+x;
	            link.put(y*M+x, list);
	            break;
	        }
	        else if(visit[ny][nx]!=-1) {
	            y = ny;
	            x = nx;
	            link.get(visit[y][x]).addAll(list);
	            break;
	        }
	        
	        visit[ny][nx] = -111111;
	        y = ny;
	        x = nx;
	        list.add(y*M+x);
	    }
	    
        for(int l : list){
            visit[l/M][l%M] = visit[y][x];
        }
	    
	    
	}
}
