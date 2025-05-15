import java.util.*;
import java.io.*;

public class Main{
    static int N, M, L, lo, hi, mid;
    static int input[];
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        input = new int[N];
        for(int i=0;i<N;i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        // 각 휴게소간의 최대 간격 -> 내가 구해야하는 녀석
        // FFFFFTTTTTT 이고
        // 이 간격으로 했을 때 값을 포함 yes -> upper;
        
        lo = 0;
        hi = L;
        
        while(lo+1<hi){
            mid = (lo+hi)/2;
            if(!check(mid)) lo = mid;
            else hi = mid;
            // System.out.println(lo+" "+mid+" "+hi);
        }
		System.out.println(hi);
	}
	static boolean check(int val){
	    pq.clear();
	    for(int i : input) pq.offer(i);
	    
	    int temp, before, count = 1;
	    
	    if(pq.isEmpty() || pq.peek()>val) temp = val;
	    else temp = pq.poll();
	    
	    while(!pq.isEmpty()){
	        count++;
	        if(count>N+M) return false;
	        
	        before = temp;
	        temp = pq.poll();
	        
	        if(temp-before > val) {
	            pq.offer(temp);
	            temp = before+val;
	        }
	    }
	    while(count<N+M){
	        count++;
	        temp += val;
	        if(temp>=L) return true;
	    }
	    return L-temp <= val;
	}
}
