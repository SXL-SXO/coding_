import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, K;
    static char input[][];
    static int dp[][][][][], alpa[];
    static int dy[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    input = new char[N][];
	    dp = new int[26][27][27][27][27];
	    
	    for(int i=0;i<N;i++) input[i] = br.readLine().toCharArray();

        alpa = new int[5];
        Arrays.fill(alpa, 26);
	    for(int i=0;i<N;i++){
	        for(int j=0;j<M;j++){
	            alpa[0] = input[i][j]-'a';
	            dp[input[i][j]-'a'][26][26][26][26]++;
	            check(i, j, 1);
	        }
	    }
	    
	    
	    char like[];
	    for(int i=0;i<K;i++){
	        like = br.readLine().toCharArray();
	        
	        Arrays.fill(alpa, 26);
	        for(int j=0;j<like.length;j++) alpa[j] = like[j]-'a';
	        
	        sb.append(dp[alpa[0]][alpa[1]][alpa[2]][alpa[3]][alpa[4]]).append("\n");
	    }
	    System.out.println(sb);
	}
	static void check(int i, int j, int idx){
	    if(idx >= 5) return;
	    
	    int ny, nx;
	    boolean visit[] = new boolean[N*M];
	    
        for(int k=0;k<8;k++){
            ny = i+dy[k];
            nx = j+dx[k];
            
            if(ny == N) ny = 0;
            else if(ny == -1) ny = N-1;
            
            if(nx == M) nx = 0;
            else if(nx == -1) nx = M-1;
            
            if(visit[ny*M+nx]) continue;
            visit[ny*M+nx] = true;
            
            alpa[idx] = input[ny][nx]-'a';
            dp[alpa[0]][alpa[1]][alpa[2]][alpa[3]][alpa[4]]++; 
            
            check(ny, nx, idx+1);
            
        }
        alpa[idx] = 26;
	}
}
