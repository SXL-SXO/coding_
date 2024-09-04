import java.io.*;
import java.util.*;


public class Main
{
    static int map[][];
    static int turn[][];
    static int N, M, K, answer = 5001;
    static int dy[] = {1, 0, -1, 0};
    static int dx[] = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    map = new int[N][M];
	    turn = new int[K][3];
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<M;j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    for(int i=0;i<K;i++){
	        st = new StringTokenizer(br.readLine());
		    turn[i][0] = Integer.parseInt(st.nextToken())-1;
		    turn[i][1] = Integer.parseInt(st.nextToken())-1;
		    turn[i][2] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int k=0;k<K;k++){
	        check(k, 1<<k);
	       // System.out.print("\n");
	       // for(int i=0;i<N;i++){
    	   //     for(int j=0;j<M;j++){
    	   //         System.out.print(map[i][j]+" ");
    	   //     }
	       //     System.out.print("\n");
	       // }
	       // System.out.print("------------------\n");
	    }
	    
	    System.out.print(answer);
	}
	static void check (int idx, int visit){
	    int R = turn[idx][0], C = turn[idx][1], S = turn[idx][2];
	    int min_r, max_r, min_c, max_c, y, x, ny, nx;
	    int temp, count;
	    
	    for(int i=1;i<=S;i++){
	        y = min_r = R - i;
	        x = min_c = C - i;
	        ny = y+1;
	        nx = x;
	        max_r = R + i;
	        max_c = C + i;
	        temp = map[min_r][min_c];
	        
	        for(int j=0;j<4;){
	            map[y][x] = map[ny][nx];
	            
	            y = ny;
	            x = nx;
	            ny += dy[j];
	            nx += dx[j];
	            
	            if(ny==max_r && nx==min_c
	             || ny==max_r && nx==max_c
	             || ny==min_r && nx==max_c
	             || ny==min_r && nx==min_c) j++;
	        }
	        
	        map[min_r][min_c+1] = temp;
 	    }
 	    
	    
	   // for(int i=0;i<N;i++){
	   //     for(int j=0;j<M;j++){
	   //         System.out.print(map[i][j]+" ");
	   //     }
    //         System.out.print("\n");
    //     }
    //     System.out.print("------------------\n");
        
        if(visit!=(1<<K)-1){
     	    
     	    for(int i=0;i<K;i++){
     	        if((visit & 1<<i) == 0) check(i, visit|(1<<i));
     	    }
	    }else{
	        for(int i=0;i<N;i++){
	            count = 0;
	            for(int j=0;j<M;j++){
	                count += map[i][j];
	            }
	            answer = Math.min(count, answer);
	        }
	    }
 	    
 	    for(int i=1;i<=S;i++){
	        y = min_r = R - i;
	        x = min_c = C - i;
	        ny = y;
	        nx = x+1;
	        max_r = R + i;
	        max_c = C + i;
	        temp = map[min_r][min_c];
	        
	        for(int j=1;j>=0;){
	            map[y][x] = map[ny][nx];
	            
	            y = ny;
	            x = nx;
	            ny += dy[j];
	            nx += dx[j];
	            
                if(ny==min_r && nx==max_c) j=0;
	            else if(ny==max_r && nx==max_c) j=3;
	            else if(ny==max_r && nx==min_c) j=2;
	            else if(ny==min_r && nx==min_c) j=-1;
	        }
	        
	       // map[min_r]
	        map[min_r+1][min_c] = temp;
 	    }
	}
}
