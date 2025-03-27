import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static Node input[];
    static int road[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    road = new int[M+1];
	    for(int i=0;i<=M;i++) road[i] = i;
	    
	    input = new Node[N];
	    for(int i=0;i<N;i++){
	        st = new StringTokenizer(br.readLine());
	        input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	    }
	    Arrays.sort(input, (o1, o2)-> o1.e-o2.e);
	    for(Node n : input){
	        if(n.s>M || n.e>M) continue;
	        if(road[n.s]+n.c < road[n.e]) {
	            road[n.e] = road[n.s]+n.c;
	            for(int j=n.e;j<=M;j++){
	                road[j] = Math.min(road[j], road[n.e]+j-n.e);
	            }
	        }
	    }
	    int answer = M;
	    for(int i=0;i<=M;i++){
	        answer = Math.min(answer, i+road[M-i]);
	    }
		System.out.print(answer);
	}
	static class Node{
	    int s, e, c;
	    Node(int s, int e, int c){
	        this.s=s;
	        this.e=e;
	        this.c=c;
	    }
	}
}
