import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int answer[][];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = new int[N+1][2];
		
		answer[0][0] = 1;
		answer[0][1] = 0;
 		for(int i=1;i<=N;i++){
		    answer[i][0] = answer[i-1][1];
		    answer[i][1] = answer[i-1][0]+answer[i-1][1];
		}
		System.out.print(answer[N][0]+" "+answer[N][1]);
	}
}
