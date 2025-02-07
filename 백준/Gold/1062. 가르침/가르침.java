import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer = 0;
    // a b c d e f g h i g k l m n o  p  q  r  s  t u  v  w  x  y  z
    // . 0 . 1 2 3 4 5 . 6 7 8 9 . 10 11 12 13 14 . 15 16 17 18 19 20
    static int bit[];
    static int alpha[] = {21, 0, 21, 1, 2, 3, 4, 5, 21, 6, 7, 8, 9, 21, 10, 11, 12, 13, 14, 21, 15, 16, 17, 18, 19, 20};
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    if(M<5) {
	        System.out.print("0");
	        return;
	    }else M -= 5;
	    
	    bit = new int[N];
	    Arrays.fill(bit, 1<<21);
	    
	    char input[];
	    int len;
	    for(int i=0;i<N;i++){
	        input = br.readLine().toCharArray();
	        len = input.length;
	        
	        for(int j=4;j<len-4;j++){
	            bit[i] |= 1<<alpha[input[j]-'a'];
	        }
	    }
	    for(int i=0;i<21;i++){
	        check((1<<21) | (1<<i), i, 1);
	    }
	    check(1<<21, 21, 0);
		System.out.println(answer);
	}
	static void check(int visit, int idx, int count){
	    if(idx>21||count>M) return;
	    else if(count == M){
	        int word = 0;
	        for(int i=0;i<N;i++){
	            if((bit[i] | visit) == visit) word++;
	        }
	        answer = Math.max(word, answer);
	        return;
	    }
	    
	    for(int i=idx+1;i<21;i++){
	        check(visit|(1<<i), i, count+1);
	    }
	}
}
