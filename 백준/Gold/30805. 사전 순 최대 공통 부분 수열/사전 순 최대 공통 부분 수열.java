import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int A[], B[];
    static List<Integer> num_A[], num_B[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> 
        (o1.value==o2.value ? o2.idx_A==o1.idx_A ? o1.idx_B-o2.idx_B : o1.idx_A-o2.idx_A : o2.value-o1.value));
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    num_A = new ArrayList[101];
	    num_B = new ArrayList[101];
	    
	    for(int i=0;i<=100;i++){
	        num_A[i] = new ArrayList<>();
	        num_B[i] = new ArrayList<>();
	    }
	    
	    N = Integer.parseInt(br.readLine());
	    A = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	        num_A[A[i]].add(i);
	    }
	        
	    M = Integer.parseInt(br.readLine());
	    B = new int[M];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<M;i++) {
	        B[i] = Integer.parseInt(st.nextToken());
	        num_B[B[i]].add(i);
	    }
	    
        for(int i=100;i>0;i--){
            if(num_A[i].size()==0 || num_B[i].size()==0) continue;
            // System.out.print(i+" / ");
            for(int a : num_A[i]){
                for(int b : num_B[i]){
                    pq.offer(new Node(i, a, b));
                }
            }
        }
	    
	    Node temp, answer = new Node(101, -1, -1);
	    StringBuilder sb = new StringBuilder();
	    
	    while(!pq.isEmpty()){
	        temp = pq.poll();
	       // System.out.println(temp.value+" "+temp.idx_A+" "+temp.idx_B);
	        if(answer.idx_A>=temp.idx_A || answer.idx_B>=temp.idx_B) continue;
	        
	        answer.idx_A = temp.idx_A;
	        answer.idx_B = temp.idx_B;
	        
	        sb.append(temp.value).append(" ");
	    }
	    if(sb.length() == 0) sb.append(0);
	    else{
	        String str[] = sb.toString().split(" ");
	        sb.insert(0, "\n").insert(0, str.length);
	    }
	    System.out.print(sb);
	}
	static class Node{
	    int value, idx_A, idx_B;
	    Node(int value, int idx_A, int idx_B){
	        this.value = value;
	        this.idx_A = idx_A;
	        this.idx_B = idx_B;
	    }
	}
}
