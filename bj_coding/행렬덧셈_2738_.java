package bj_coding;
import java.util.*;
import java.io.*;

public class 행렬덧셈_2738_ {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		StringTokenizer getNum = new StringTokenizer(str);
		
		int N = Integer.parseInt(getNum.nextToken());
		int M = Integer.parseInt(getNum.nextToken());
		
		int[][] arr1 = new int[N][M];
		int[][] arr2 = new int[N][M];
		int[][] answer = new int[N][M];

		for(int i=0;i<N;i++){
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr1[i][j] = Integer.parseInt(str1.nextToken());
			}
		}
		for(int i=0;i<N;i++){
			StringTokenizer str1 = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr2[i][j] = Integer.parseInt(str1.nextToken());
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				answer[i][j] = arr1[i][j]+arr2[i][j];
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(answer[i][j]+" ");
			}
			System.out.println("");
		}


	}
}
