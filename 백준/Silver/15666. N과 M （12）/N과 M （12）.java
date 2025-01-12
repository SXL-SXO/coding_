import java.util.*;
import java.io.*;

public class Main
{
	static int N, M;
	static int input[];
	static Set<String> set = new LinkedHashSet<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        input = new int[N];
        
        st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		
		for(int i=0;i<N;i++){
		    check(i, 1, input[i]+" ");
		}
		for(String s : set){
		    sb.append(s).append("\n");
		}
		System.out.print(sb);
	}
	static void check(int idx, int t, String s){
	    if(t==M){
	        set.add(s);
	        return;
	    }
	    for(int i=idx;i<N;i++){
		    check(i, t+1, s+input[i]+" ");
		}
	}
}
