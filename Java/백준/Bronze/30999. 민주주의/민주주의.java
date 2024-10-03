import java.util.*;
import java.io.*;

public class Main
{
    static int a, b, answer;
    static char input[];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    a = Integer.parseInt(st.nextToken());
	    b = (Integer.parseInt(st.nextToken())+1)/2;
	    
	    int count = 0;
	    for(int i=0;i<a;i++){
	        if(count>=b) answer++;
	        count = 0;
	        input = br.readLine().toCharArray();
	        
	        for(char c : input){
	            if(c=='O') count++;
	        }
	    }
	    if(count>=b) answer++;
		System.out.println(answer);
	}
}
