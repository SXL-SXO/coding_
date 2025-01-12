import java.util.*;
import java.io.*;

public class Main
{
	static int N, M;
	static int input[];
	static boolean num[];
	static Set<String> set = new LinkedHashSet<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        input = new int[N];
        num = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		for(int i=0;i<N;i++){
		    num[i] = true;
		    check(1, input[i]+" ");
		    num[i] = false;
		}
		for(String s : set){
		    sb.append(s).append("\n");
		}
		System.out.print(sb);
	}
	static void check(int t, String s){
	    if(t==M){
	        set.add(s);
	        return;
	    }
	    for(int i=0;i<N;i++){
	        if(num[i]) continue;
		    num[i] = true;
		    check(t+1, s+input[i]+" ");
		    num[i] = false;
		}
	}
}
