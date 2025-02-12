import java.io.*;
import java.util.*;

public class Main
{
    static int answer = 0, N, M, a =-1, b=-1;
    static int root[], rank[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    root = new int[N];
	    rank = new int[N];
	    for(int i=0;i<N;i++) root[i] = i;
	    
	    for(int i=1;i<=M;i++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        
	        switch_num();
	        
	        if(union(a, b)) {
	            answer = i;
	            break;
	        }
	    }
	    
		System.out.println(answer);
	}
	static int find(int idx){
	    if(root[idx] == idx) return idx;
	    return root[idx] = find(root[idx]);
	}
	static boolean union(int x, int y){
        int xr = find(x);
        int yr = find(y);
        
        if(xr == yr) return true;
        
        if(rank[xr] < rank[yr]) root[xr] = yr;
        else if(rank[xr] > rank[yr]) root[yr] = xr;
        else{
            if(xr<yr){
                rank[xr]++;
                root[yr] = xr;
            }else{
                rank[yr]++;
                root[xr] = yr;
            }
        }
        return false;
	}
	static void switch_num(){
	    int temp;
	    if(a<b) return;
	    
	    temp = a;
	    a = b;
	    b = temp;
	}
}
