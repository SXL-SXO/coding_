import java.util.*;
import java.io.*;


public class Main
{
    static char[] temp_1, temp_2;
    static int T, N, size_1, size_2;
    static boolean check ;
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
		    N = Integer.parseInt(br.readLine());
		    for(int i=0;i<N;i++){
		        pq.offer(br.readLine().replace(" ",""));
		    }
		    
		    temp_1 = pq.poll().toCharArray();
		    size_1 = temp_1.length;
		    check  = true;
		    total : while(check && !pq.isEmpty()){
		        
		        temp_2 = pq.poll().toCharArray();
		        size_2 = temp_2.length;
		        
		        for(int i=0;i<size_1;i++){
		            if(i>=size_2) break;
		            else if(temp_2[i]!=temp_1[i]){
		                temp_1 = temp_2;
		                size_1 = size_2;
		                continue total;
		            }
		        }
		        check = false;
		    }
		    pq.clear();
		    if(check) sb.append("YES").append("\n");
		    else sb.append("NO").append("\n");
		}
		System.out.print(sb.toString());
	}
}
