// 01:05
import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int input[], output[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    input = new int[N];
	    output = new int[M];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
	    
	    
	    //정렬, 무조건 뒷 녀석을 가져오기 위해서
	    Arrays.sort(input);
	    
	    make(0, 0);
	    
		System.out.println(sb);
	}
	static void make(int idx, int count){
	    if(count == M){
	        for(int n : output) sb.append(n).append(" ");
	        sb.append("\n");
	        return;
	    }
	    
	    for(int i=idx;i<N;i++){
	        output[count] = input[i];
	        make(i, count+1);
	    }
	}
}
