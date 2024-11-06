import java.util.*;
import java.io.*;

public class Main
{
    static StringBuilder sb = new StringBuilder();
    static int input[], score[] = {11, 8, 12};
    static int N;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int sum, num = 0;
	    boolean success;
	    N = Integer.parseInt(br.readLine());
	    for(int i = 0;i<N;i++){
	        sum = 0;
	        success = true;
	        st = new StringTokenizer(br.readLine());
	        sb.append(st.nextToken()).append(" ");
	        for(int j=0;j<3;j++){
	            num = Integer.parseInt(st.nextToken());
	            success = success && num>=score[j];
	            sum+=num;
	        }
            success = success && sum>=55;
	        sb.append(sum).append(" ").append(success ? "PASS" : "FAIL").append("\n");
	    }
	    System.out.print(sb);
	}
}