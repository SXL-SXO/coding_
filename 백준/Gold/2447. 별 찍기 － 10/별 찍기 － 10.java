import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static StringBuilder answer[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		answer = new StringBuilder[N];
		
// 		Arrays.fill(star[0], ' ');
// 		Arrays.fill(star[1], ' ');
// 		Arrays.fill(star[2], ' ');
		
		answer[0] = new StringBuilder("***");
		answer[1] = new StringBuilder("* *");
		answer[2] = new StringBuilder("***");
		
		check(3);
		System.out.print(sb);
	}
	static void check(int three){
	    if(three == N) {
	        for(int i=0;i<N;i++) sb.append(answer[i]).append("\n");
	        return;
	    }
	    
	    StringBuilder blank = new StringBuilder();
	    StringBuilder star;
	    
	    for(int i=0;i<three;i++) blank.append(" ");
	    
	    for(int i=0;i<three;i++){
	        star = new StringBuilder(answer[i]);
	        answer[i+three] = new StringBuilder(star);
	        answer[i+three].append(blank).append(star);
	        answer[i].append(star).append(star);
	        answer[i+three*2] = new StringBuilder(answer[i]);
	    }
	    
	    check(three*3);
	}
}
