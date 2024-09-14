import java.io.*;
import java.util.*;
public class Main
{
    static int N, M;
    static List<Integer> first = new ArrayList<>();
    static List<Integer> second = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int rank;
        for(int i=1;i<=N;i++){
            rank = Integer.parseInt(br.readLine())-1;
            first.add(rank, i);
        }
        for(int i=M-1;i>=0;i--){
            rank = Integer.parseInt(br.readLine())-1;
            second.add(rank, first.get(i));
        }
        for(int i=0;i<3;i++){
            sb.append(second.get(i)).append("\n");
        }
		System.out.print(sb);
	}
}
