import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static Node input_s[];
    // 본인 (i) 보다 작은 것 저장함 
    // 여기서 poll 했을 때 본인 i 보다 큰 녀석이 나오면 계속 sum++ 해주고
    // 본인보다 작은 녀석 j가 나온다면 num[i] = num[j]+sum
    // 근데 여기서 동일한 숫자는 어떻게 처리해야할까,,?
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    N = Integer.parseInt(br.readLine());
	    input_s = new Node[N+1];
	    input_s[0] = new Node(0, -1);
	    
	    for(int i=1;i<=N;i++) {
	        input_s[i] = new Node(i, Integer.parseInt(br.readLine()));
	    }
	    Arrays.sort(input_s, 
	        (o1, o2) -> o1.val==o2.val ? o1.idx-o2.idx : o1.val-o2.val);
	    
	    Node temp;
	    for(int i=1;i<=N;i++){
	        if(input_s[i].idx<=i) continue;
	        answer = Math.max(answer, input_s[i].idx-i);
	    }
	    
	    System.out.print(answer+1);
	}
	static class Node{
	    int idx, val;
	    Node(int idx, int val){
	        this.idx = idx;
	        this.val = val;
	    }
	}
}
