import java.util.*;
import java.io.*;
public class Main
{
    static int answer = 0;
    static int input[] = new int[10];
    static int map[] = new int[64], point[] = new int[64];
    static Queue<Node> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    for(int i=0;i<10;i++) input[i] = Integer.parseInt(st.nextToken());
	    
	    init();
	    bfs();
	    cal();
	    
		System.out.println(answer);
	}
	static void cal(){
	    while(!queue.isEmpty()){
	       // System.out.println(queue.poll());
	        answer = Math.max(answer, queue.poll().score);
	    }
	}
	static void bfs(){
	    int size, sum;
	    Node temp, next;
	    
	    if(input[0]<5) queue.offer(new Node(new int[]{input[0], 0, 0, 0}, point[input[0]]));
	    else queue.offer(new Node(new int[]{30, 0, 0, 0}, point[input[0]]));
	    for(int i=1;i<10;i++){
	        size = queue.size();
	        for(int j=0;j<size;j++){
	            temp = queue.poll();
	            for(int k=0;k<4;k++){
	                if(temp.w[k] == -1) continue;
	                
	                next = new Node(Arrays.copyOf(temp.w, 4), temp.score);
	                sum = next.w[k]+input[i];
	                
	               // System.out.println(k+" "+sum+" "+Arrays.toString(next.w));
	                
	                if(sum == 5) next.w[k] = 30;
	                else if(sum == 10) next.w[k] = 40;
	                else if(sum == 15) next.w[k] = 50;
	                else if(sum == 20) next.w[k] = 63;
	                
	                else if(next.w[k]/10 == 5 && sum > 53) next.w[k] = sum+6;
	                else if(next.w[k]/10 == 4 && sum > 42) next.w[k] = sum+17;
	                else if(next.w[k]/10 == 3 && sum > 33) next.w[k] = sum+26;
	                else if(next.w[k]/10 == 1 && sum > 20) next.w[k] = -1;
	                else next.w[k] = sum;
	                
	                if(next.w[k] > 63) next.w[k] = -1;
	                else if(next.w[k] > 0) next.score += point[next.w[k]];
	                
	                if(!check(next, k)) queue.offer(next);
	            }
	        }
	    }
	}
	static class Node{
	    int w[];
	    int score;
	    Node(int w[], int score){
	        this.w=w;
	        this.score=score;
	    }
	    
	    public String toString() {
	        return Arrays.toString(this.w)+" "+this.score;
	    }
	}
	static boolean check(Node n, int idx){
	    boolean res = false;
	    for(int i=0;i<4;i++) {
	        if( i==idx || n.w[i]<=0 ) continue;
	        res |= n.w[i]==n.w[idx];
	    }
	    return res;
	}
	static void init(){
	    for(int i=0;i<21;i++) point[i] = i*2;
	    point[30] = 10;
	    point[31] = 13;
	    point[32] = 16;
	    point[33] = 19;
	    point[40] = 20;
	    point[41] = 22;
	    point[42] = 24;
	    point[50] = 30;
	    point[51] = 28;
	    point[52] = 27;
	    point[53] = 26;
	    point[60] = 25;
	    point[61] = 30;
	    point[62] = 35;
	    point[63] = 40;
	}
}
