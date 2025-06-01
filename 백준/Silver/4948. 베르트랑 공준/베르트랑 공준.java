import java.util.*;
import java.io.*;

public class Main
{
    static int N, count;
    static boolean num[] = new boolean[246913];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    for(int i=3;i<=246912;i+=2){
	        for(int j=2;i*j<=246912; j++){
	            num[i*j] = true;
	        }
	    }
	    
	    
	    N = Integer.parseInt(br.readLine());
	    while(N!=0){
	        count = 0;
	        for(int i=N+1;i<=2*N;i++){
	            if(i!=2 && (i%2==0 || num[i])) continue;
	            count++;
	        }
	        sb.append(count).append("\n");
	        N = Integer.parseInt(br.readLine());
	    } 
	    
		System.out.println(sb);
	}
}
