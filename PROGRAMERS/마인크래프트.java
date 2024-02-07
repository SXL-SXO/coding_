import java.io.*;
import java.util.*;

class Pos {
	int y, x;

	Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
public class 마인크래프트 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int block[][] = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                block[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<Integer, ArrayList<Pos>> map = new HashMap<>();

        ArrayList<Pos> arr;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                Pos now = new Pos(i,j);
                if(map.containsKey(block[i][j])){
                    arr = map.get(block[i][j]);
                    arr.add(now);
                    map.put(block[i][j], arr);
                }else{
                    
                }
            }
        }
        
    }
}
