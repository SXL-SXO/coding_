import java.io.*;
import java.util.*;
public class Main
{
    static int N, M;
    static Long answer = 0L;
    static List<ArrayDeque<Integer>> name = new ArrayList<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    for(int i=0;i<=20;i++){
	        name.add(new ArrayDeque<>());
	    }
	    
	    String input;
	    int length;
	    for(int i=0;i<N;i++){
	        input = br.readLine();
	        length = input.length();
	        
	        while(!name.get(length).isEmpty() && name.get(length).peek()<i-M){
	            name.get(length).poll();
	        }
	        
	        answer += name.get(length).size();
	        name.get(length).offer(i);
	    }
	    
		System.out.print(answer);
	}
}
