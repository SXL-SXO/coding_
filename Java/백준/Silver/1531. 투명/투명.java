import java.io.*;
import java.util.*;
public class Main
{
	static int N, M, answer = 0;
	static int count[][] = new int[100][100];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int x1, y1, x2, y2;
		for(int a=0; a<N; a++) {
			st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
		    y1 = Integer.parseInt(st.nextToken());
		    x2 = Integer.parseInt(st.nextToken());
		    y2 = Integer.parseInt(st.nextToken());
		    
		    for(int i=x1-1;i<x2;i++){
		        for(int j=y1-1;j<y2;j++){
		            count[i][j]++;
		        }
		    }
		}
		for(int i=0;i<100;i++){
	        for(int j=0;j<100;j++){
	            if(count[i][j]>M) answer++;
	        }
	    }
		System.out.println(answer);
	}
}
