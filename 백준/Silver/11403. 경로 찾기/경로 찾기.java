import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static boolean num[], check[][];
    static List<List<Integer>> link = new ArrayList<>();
    
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    num = new boolean[N];
	    check = new boolean[N][N];
	    
	    for(int i=0;i<N;i++) link.add(new ArrayList());
	    
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0;j<N;j++){
	            if(Integer.parseInt(st.nextToken()) == 1) link.get(i).add(j); 
	        }
	    }
	    
	    Queue<Integer> queue = new ArrayDeque<>();
	    
	    int temp;
	    for(int i=0;i<N;i++){
	        queue.offer(i);
	        while(!queue.isEmpty()){
	            temp = queue.poll();
	            for(int n : link.get(temp)){
	                if(check[i][n]) continue;
	                check[i][n] = true;
	                queue.offer(n);
	            }
	        }
	    }
	    
	    for(int i=0;i<N;i++){
	        for(int j=0;j<N;j++){
	            if(check[i][j]) sb.append("1 ");
	            else sb.append("0 ");
	        }
	        sb.append("\n");
	    }
	    System.out.print(sb);
	}
}
