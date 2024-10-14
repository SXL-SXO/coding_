import java.util.*;
import java.io.*;

public class Main
{
    static int T, W, answer = 0;
    static boolean input[];
    static int tree[][][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		input = new boolean[T];
		tree = new int[T][W+1][2];
		for(int t = 0; t < T; t++){
		    input[t] = br.readLine().equals("1");
		}
		
		if(input[0]) tree[0][0][0] = 1;
		else tree[0][1][1] = 1;
		
		int add_1, add_2;
		for(int t=1;t<T;t++){
            add_1 = input[t] ? 1 : 0;
            add_2 = input[t] ? 0 : 1;
            
	        tree[t][0][0] = tree[t-1][0][0]+add_1;
	        tree[t][0][1] = tree[t-1][0][1]+add_2;
            
            for(int w=1;w<=W;w++){
	            tree[t][w][0] = Math.max(tree[t-1][w][0], tree[t-1][w-1][1])+add_1;
	            tree[t][w][1] = Math.max(tree[t-1][w][1], tree[t-1][w-1][0])+add_2;
		    }
		}
// 		for(int t=0;t<T;t++){
//             for(int w=0;w<=W;w++){
//                 System.out.print(Arrays.toString(tree[t][w])+" ");
//             }
//             System.out.println("");
// 		}
		for(int w=0;w<=W;w++){
            answer = Math.max(answer, Math.max(tree[T-1][w][0], tree[T-1][w][1]));
        }
		System.out.print(answer);
	}
}
