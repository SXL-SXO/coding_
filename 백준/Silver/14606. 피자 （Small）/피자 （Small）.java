import java.util.*;
import java.io.*;
public class Main
{
    static int answer = 0;
    static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		queue.offer(Integer.parseInt(br.readLine()));
		
		int temp1, temp2, temp;
		while(!queue.isEmpty()){
		    temp = queue.poll();
		    if(temp==1) continue;
		    
		    temp1 = temp/2;
		    temp2 = temp-temp1;
		    answer += temp1*temp2;
		    queue.offer(temp1);
		    queue.offer(temp2);
		}
		System.out.println(answer);
	}
}
