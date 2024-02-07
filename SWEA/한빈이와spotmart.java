import java.util.*;
import java.io.*;

public class 한빈이와spotmart {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
            sb.append("#").append(test_case).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int snack[] = new int[N];
            st = new StringTokenizer(br.readLine());
            int answer = -1;
            for(int i=0;i<N;i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(snack);
            for(int i=snack.length-1;i>0;i--){
                for(int j=i-1;j>-1;j--){
                    if(snack[i]+snack[j]<=M){
                        answer = Math.max(snack[i]+snack[j], answer);
                        break;
                    }
                }
            }
            sb.append(answer).append("\n");
		}
        System.out.println(sb.toString());
	}
}