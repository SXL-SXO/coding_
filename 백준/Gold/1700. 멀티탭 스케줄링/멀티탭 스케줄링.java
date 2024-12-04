import java.util.*;
import java.io.*;

public class Main
{
    static int N, K, answer = 0;
    static int input[], before[], use[];
    static boolean check[];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> (o1.before-o2.before));
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    input = new int[K+1];
	    
	    // 지금 써야하는 K번째 녀석을 그 전에는 언제 썼을까?
	    before = new int[K+1];
	    
	    // i번째 녀석은 a번에서 사용했다 use[i] = a;
	    use = new int[K+1];
	    
	    // i번째 녀석은 pq안에 몇개가 있다
	    check = new boolean[K+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=K;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	        before[i] = use[input[i]];
	        use[input[i]] = i;
	    }
	    
	    // pq안에 있는 종류 갯수
	    int count = 0;
	    Node temp;
	    for(int i=K;i>0;i--){
	        if(!check[input[i]]) {
	            if(count == N){
	                temp = pq.poll();
	                check[temp.num] = false;
	                answer++;
	            }else count++;
	        }
	        check[input[i]]=true;
	        pq.offer(new Node(input[i],before[i]));
	    }
	    System.out.print(answer);
	}
	static class Node{
        int num, before;
        Node(int num, int before){
            this.num = num;
            this.before = before;
        }
    }

}
