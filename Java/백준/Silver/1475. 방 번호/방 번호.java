import java.util.*;
import java.io.*;
public class Main
{
    static char input[];
    static int answer = 0;
    static int num[] = new int[10];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    input = br.readLine().toCharArray();
	    for(char c:input){
	        num[c-'0']++;
	    }
	    for(int i=0;i<9;i++){
	        if(i==6) continue;
	        answer = Math.max(answer, num[i]);
	    }
	    answer = Math.max(answer, (num[6]+num[9]+1)/2);
		System.out.println(answer);
	}
}
