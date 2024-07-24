import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int answer[];
    static boolean col[], cross[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		answer = new int[N];
		col = new boolean[N];
		cross = new boolean[N*2-1][2];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++){
		    answer[i] = Integer.parseInt(st.nextToken());
		    if(answer[i] == 0) continue;
		    else if(col[answer[i]-1] || cross[N+i-answer[i]][0] || cross[i+answer[i]-1][1]) {
		        System.out.print("-1");
		        return;
		    }
		    col[answer[i]-1] = true;
		    cross[N+i-answer[i]][0] = true;
		    cross[i+answer[i]-1][1] = true;
		}
		
		dfs(0);
		if(sb.length()==0) sb.append("-1");
		System.out.print(sb);
	}
	static void dfs(int i){
	    if(i==N){
	        for(int j=0;j<N;j++){
	            if(answer[j]!=0) sb.append(answer[j]).append(" ");
	            else {
	                sb.setLength(0);
	                return;
	            }
	        }
	        return;
	    }
	    if(answer[i]!=0) {
	        dfs(i+1);
	        return;
	    }
	    for(int j=0;j<N;j++){
	        if(col[j] || cross[N-1+i-j][0] || cross[i+j][1]) continue;
	        
	        col[j] = true;
	        cross[N-1+i-j][0] = true;
	        cross[i+j][1] = true;
	        answer[i] = j+1;
	        
	        dfs(i+1);
	        if(sb.length()!=0) return;
	        
	        answer[i] = 0;
	        col[j] = false;
	        cross[N-1+i-j][0] = false;
	        cross[i+j][1] = false;
	    }
	}
}
