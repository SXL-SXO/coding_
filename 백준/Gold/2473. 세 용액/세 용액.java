import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int input[], answer[];
    static long total = 3000000001L;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		answer = new int[3];
		input = new int[N];
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(input);
		
		long sum;
		int l = 0, r = 2, m = 1;
		
        // System.out.println(Arrays.toString(input));
		tot : for(int i=0;i<N;i++){
		    for(int j=i+2;j<N;j++){
		        sum = input[i]+input[j];
		        l = i;
		        r = j;
		        m = (l+r+1)/2;
		        while(l!=m && m!=r){
		          //  System.out.println(l+" "+m+" "+r);
		            
		            if(sum+input[m]<0) l = m;
		            else if(sum+input[m]>0) r = m;
		            else if(m!=i && m!=j){
		                answer[0] = input[i];
		                answer[1] = input[m];
		                answer[2] = input[j];
		                break tot;
		            }m = (l+r+1)/2;
		        }
		        
		      //  System.out.println(input[i]+", "+input[j]+"일때, end : "+l+" "+m+" "+r);
		        if(r!=i && r!=j && total>Math.abs(sum+(long)input[r])) {
		            
		      //  System.out.println(input[i]+", "+input[j]+"일때, end : "+l+" "+m+" "+r);
		            total = Math.abs(sum+(long)input[r]);
		            answer[0] = input[i];
		            answer[1] = input[r];
		            answer[2] = input[j];
		        }
		        if(m!=i && m!=j && total>Math.abs(sum+(long)input[m])) {
		            
		      //  System.out.println(input[i]+", "+input[j]+"일때, end : "+l+" "+m+" "+r);
		            total = Math.abs(sum+(long)input[m]);
		            answer[0] = input[i];
		            answer[1] = input[m];
		            answer[2] = input[j];
		        }
		        if(l!=i && l!=j && total>Math.abs(sum+(long)input[l])) {
		      //  System.out.println(input[i]+", "+input[j]+"일때, end : "+l+" "+m+" "+r);
		            total = Math.abs(sum+(long)input[l]);
		            answer[0] = input[i];
		            answer[1] = input[l];
		            answer[2] = input[j];
		        }
		    }
		}
		sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
		System.out.println(sb);
	}
}
