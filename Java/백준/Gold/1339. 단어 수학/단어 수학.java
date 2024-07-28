import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int alpa[] = new int[26];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++){
		    String input = br.readLine();
		    int len = input.length();
		    for(int j=0;j<len;j++){
		        alpa[input.charAt(len-1-j)-'A'] += Math.pow(10, j);
		    }
		}
		Arrays.sort(alpa);
		
		int answer = 0;
		for(int i=25;i>15;i--){
		    answer += alpa[i]*(i-16);
		}
		
		System.out.print(answer);
	}
}