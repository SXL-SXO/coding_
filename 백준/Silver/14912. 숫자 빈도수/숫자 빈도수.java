import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static int count[] = new int[10];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    int temp;
	    for(int i=1;i<=N;i++){
	        temp = i;
	        while(temp>9){
	            count[temp%10]++;
	            temp/=10;
	        }
	        count[temp]++;
	    }
	    
	    System.out.print(count[M]);
	}
}
