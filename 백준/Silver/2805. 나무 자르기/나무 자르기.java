import java.util.*;
import java.io.*;

public class Main
{
    static int N, M, answer;
    static int input[], num[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new int[N];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(input);
	    
	    if(N==1) {
	        System.out.print(input[0]-M);
	        return;
	    }
	    // 하나를 잘랐을때
	    int count = 1, sum = 0;
	    
	    // 몇개를 잘랐을 때의 값이 M보다 큰가
	    for(;count<N;count++){
	        if(sum+(input[N-count]-input[N-count-1])*count>=M) break;
	        sum += (input[N-count]-input[N-count-1])*count;
	    }
	    answer = input[N-count];
	    
	   // System.out.println(sum+" "+count+" "+answer);
	    while(sum<M){
	        sum += count;
	        answer--;
	    }
	    
	    System.out.print(answer);
	}
	static int gcd(int a, int b){
	    if(a<b){
	        int temp = a;
	        a = b;
	        b = temp;
	    }
	    
	    if(a%b==0) return b;
	    
	    return gcd(b, a%b);
	}
}
