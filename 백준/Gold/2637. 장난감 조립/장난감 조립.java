import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static int answer[]; // i번째가 k개 필요하다
    static int input[][]; // i번째를 만드는데 j가 k개 필요하다
    static int make[];
    static boolean used[];
    static Queue<Node> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    make = new int[N];
	    answer = new int[N];
	    used = new boolean[N];
	    input = new int[N+1][N+1];
	    
	    int X, Y, K;
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        
	        X = Integer.parseInt(st.nextToken());
	        Y = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        
	        input[X][Y] = K;
	        if(X==N) queue.offer(new Node(Y, K));
	        else used[X] = true;
	    }
	    
	    Node temp;
	    int size;
	    while(!queue.isEmpty()){
	        size = queue.size();
	        for(int j=0;j<size;j++){
    	        temp = queue.poll();
    	        if(!used[temp.idx]) {
    	            answer[temp.idx] += temp.count;
    	            continue;
    	        }
    	        
    	        for(int i=1;i<N;i++){
    	            make[i] += temp.count*input[temp.idx][i];
    	        }
	        }
	        for(int i=1;i<N;i++){
	            if(make[i]!=0) queue.offer(new Node(i, make[i]));
	            make[i] = 0;
	        }
	    }
	    
	   // for(int i=N;i>0;i--){
	   //     if(!used[i]) continue;
	   //     for(int j=N;j>0;j--){
	   //         make[j] += input[i][j]*make[i];
	   //     }
	   // }
	    
	    for(int i=1;i<N;i++){
	        if(!used[i]) sb.append(i).append(" ").append(answer[i]).append("\n");
	    }
		System.out.println(sb);
	}
	static class Node{
	    int idx, count;
	    Node(int idx, int count){
	        this.idx = idx;
	        this.count = count;
	    }
	}
}
