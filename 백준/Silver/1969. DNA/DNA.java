import java.util.*;
import java.io.*;
public class Main
{
    static int N, M, num = 0;
    static char value[], input[][];
    static int count[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		input = new char[N][];
		count = new int[M][4];
		value = new char[] {'A', 'C', 'G', 'T'};
		for(int i=0;i<N;i++){
		    input[i] = br.readLine().toCharArray();
		    for(int j=0;j<M;j++){
		        if(input[i][j]=='A') count[j][0]++;
		        else if(input[i][j]=='C') count[j][1]++;
		        else if(input[i][j]=='G') count[j][2]++;
		        else count[j][3]++;
		    }
		}
		
		for(int i=0;i<M;i++){
		    int max_i = 0;
		    for(int j=1;j<4;j++){
		        if(count[i][max_i]<count[i][j]) max_i = j;
		    }
		    num += N - count[i][max_i];
		    sb.append(value[max_i]);
		}
		sb.append("\n").append(num);
		
		System.out.print(sb);
	}
}
