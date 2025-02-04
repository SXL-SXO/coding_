import java.io.*;
import java.util.*;

public class Main
{
    static int N, count = 0;
    static int where[];
    static char input[];
    static Stack<Integer> queue = new Stack<>();
    static String answer[];
    static StringBuilder sb = new StringBuilder();
    static StringBuilder split = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    N = input.length;
	    
	    where = new int[N];
	    Arrays.fill(where, -1);
	    
	    for(int i=0;i<N;i++){
	        if(input[i]=='(') {
	            where[i] = count;
	            queue.push(count++);
	        }else if(input[i]==')') {
	            where[i] = queue.pop();
	        }
	    }
	    
	    answer = new String[(int)Math.pow(2, count)-1];
	    
	    for(int i=0;i<count;i++){
	        remove(1<<i, i);
	    }
	    
	    Arrays.sort(answer);
	    sb.append(answer[0]).append("\n");
	    for(int i=1;i<answer.length;i++) 
	        if(!answer[i-1].equals(answer[i])) sb.append(answer[i]).append("\n");
	    
		System.out.print(sb);
	}
	static void remove(int check, int last_idx){
	    if(last_idx>=count) return;
	    
	    split.setLength(0);
	    for(int i=0;i<N;i++){
	        if(where[i]>=0 && (((1<<where[i]) & check) != 0) ) continue;
	        else split.append(input[i]);
	    }
	    answer[check-1] = split.toString();
	    
	    last_idx++;
	    remove(check, last_idx);
	    remove(check|(1<<last_idx), last_idx);
	}
}
