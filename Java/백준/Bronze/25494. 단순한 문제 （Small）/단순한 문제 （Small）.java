import java.io.*;
import java.util.*;
public class Main
{
    static int T, a, b, c, count;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0;t<T;t++){
	        st = new StringTokenizer(br.readLine());
	        a = Integer.parseInt(st.nextToken());
	        b = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        
	        count = 0;
	        for(int i=1;i<=a;i++){
	            for(int j=1;j<=b;j++){
	                for(int k=1;k<=c;k++){
	                    if(i%j==j%k && j%k==k%i) count++;
	                }
	            }
	        }
	        sb.append(count).append("\n");
	    }
		System.out.print(sb);
	}
}
