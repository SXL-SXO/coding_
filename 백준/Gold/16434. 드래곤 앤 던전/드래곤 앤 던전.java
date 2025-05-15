import java.util.*;
import java.io.*;

public class Main{
    static int N, H;
    static Node input[];
    static long lo = 0, hi = 1, mid;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        input = new Node[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            input[i] = new Node(Integer.parseInt(st.nextToken()) == 1, Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        
            if(input[i].type) hi += (input[i].a + (long)(H-1)) * input[i].h / (long)H ;
        }
        // 최소의 생명력 -> 내가 구해야하는 녀석
        // FFFFFTTTTTT 이고
        // 이 간격으로 했을 때 값을 포함 no -> low;
        
        while(lo+1<hi){
            mid = (lo+hi)/2;
            if(!check(mid)) lo = mid;
            else hi = mid;
            // System.out.println(lo+" "+mid+" "+hi);
        }
		System.out.println(hi);
	}
	static boolean check(long max){
	    long hero = max, attack = H;
	    
	    for(Node n : input){
	        if(n.type) {
	           // System.out.print(n.h/attack +" "+ hero/n.a+" ||");
                if(n.h%attack == 0) hero -= (n.h/attack-1)*n.a;
                else hero -= n.h/attack*n.a;
                
                if(hero<=0) return false;
	        }else{
	            hero = Math.min(max, hero+n.h);
	            attack += n.a;
	        }
	    }
	    return true;
	}
	static class Node{
	    boolean type;
	    long a, h;
	    Node(boolean type, long a, long h){
	        this.type = type;
	        this.a = a;
	        this.h = h;
	    }
	}
}
