import java.util.*;
import java.io.*;

public class Main
{
	static int N, temp;
	static int input[], answer[];
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int [N];
        answer = new int [N];
        Arrays.fill(answer, -1);
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(input[N-1]);
	    for(int i=N-2;i>=0;i--){
	        while(!stack.isEmpty()){
	            temp = stack.pop();
	            if(temp > input[i]){
	                answer[i] = temp;
	                stack.push(temp);
	                break;
	            }
	        }
	        stack.push(input[i]);
	    }
	    
	    for(int i=0;i<N;i++){
	        sb.append(answer[i]).append(" ");
	    }
	    System.out.print(sb);
	}
}
