import java.util.*;
import java.io.*;
public class Main
{
    static int N = 1;
    static int input[], num[] = new int[6];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true){
		    st = new StringTokenizer(br.readLine());
		    N = Integer.parseInt(st.nextToken());
		    
		    if(N==0) break;
		    input = new int[N];
		    
		    for(int i=0;i<N;i++){
		        input[i] = Integer.parseInt(st.nextToken());
		    }
		    
		    for(int i=0;i<=N-6;i++){
		        num[0] = input[i];
		        check(i, 1);
		    }
		    sb.append("\n");
		}
		
		System.out.print(sb);
	}
	static void check(int idx, int count){
	    if(count==6){
	        for(int i=0;i<6;i++) sb.append(num[i]).append(" ");
	        sb.append("\n");
	        
	        return;
	    }
	    
	    for(int i=idx+1;i<=N-6+count;i++){
	        num[count] = input[i];
		    check(i, count+1);
	    }
	}
}
