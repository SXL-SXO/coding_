import java.util.*;
import java.io.*;

public class Main
{
	static int N, answer = 0;
	static int input[];
	static List<Integer> lis = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		input = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
    
        lis.add(input[0]);
        
        int where;
		for(int i=1;i<N;i++){
		    where = find(input[i]);
		    if(where == lis.size()) lis.add(input[i]);
		    else lis.set(where, input[i]);
		}
		
		System.out.print(lis.size());
	}
	static int find(int val){
	    // TTTT FFFFFFF
		int lo = -1, hi = lis.size(), mid;
		mid = (lo+hi)/2;
		
		while(lo+1<hi) {
			mid = (lo+hi)/2;

			if(check(val, mid)) lo = mid;
			else hi = mid;
		}
		return hi;
	}
	static boolean check(int val, int idx){
	    if(lis.get(idx)<val) return true;
	    return false;
	}
}
