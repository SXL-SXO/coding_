import java.io.*;
import java.util.*;
public class Main
{
    static int N, size, answer = 0;
    static Node input[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new Node[N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            input[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(input, (o1,o2)->o2.end-o1.end);
        answer = input[0].end;
        
        for(int i=0;i<N;i++){
            answer = Math.min(input[i].end, answer);
            answer -= input[i].time;
        }
        answer = answer<0 ? -1 : answer;
        System.out.print(answer);
	}
	static class Node{
	    int time, end;
	    Node(int time, int end){
	        this.time = time;
	        this.end = end;
	    }
	}
}
