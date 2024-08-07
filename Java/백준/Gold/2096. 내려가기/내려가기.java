import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int input[][], min[][], max[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		input = new int[N][3];
		min = new int[N][3];
		max = new int[N][3];
		for(int i=0;i<N;i++){
		    st = new StringTokenizer(br.readLine());
		    for(int j=0;j<3;j++){
		        min[i][j] = max[i][j] = input[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		for(int i=1;i<N;i++){
		    min[i][0] = Math.min(min[i-1][0],min[i-1][1]);
		    min[i][2] = Math.min(min[i-1][2],min[i-1][1]);
		    min[i][1] = Math.min(min[i][0],min[i][2]);
		    
		    max[i][0] = Math.max(max[i-1][0],max[i-1][1]);
		    max[i][2] = Math.max(max[i-1][2],max[i-1][1]);
		    max[i][1] = Math.max(max[i][0],max[i][2]);
		    
		    for(int j=0;j<3;j++){
		        max[i][j]+=input[i][j];
		        min[i][j]+=input[i][j];
		    }
		}
		int answer_min = 900001, answer_max = 0;
		for(int i=0;i<3;i++){
		    answer_max = Math.max(answer_max, max[N-1][i]);
		    answer_min = Math.min(answer_min, min[N-1][i]);
		}
		
		System.out.println(answer_max+" "+answer_min);
	}
}
