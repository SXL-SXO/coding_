import java.util.*;
import java.io.*;
public class Main
{
    static StringBuilder sb = new StringBuilder();
    static boolean num[] = new boolean[10001];
	public static void main(String[] args) throws Exception{
	    int sum;
	    char n[];
	    for(int i=1;i<=10000;i++){
	        n = String.valueOf(i).toCharArray();
	        sum = i;
	        for(char c : n) sum+=c-'0';
	        
	        if(sum>10000) continue;
	        num[sum] = true;
	    }
	    for(int i=1;i<=10000;i++){
	        if(!num[i]) sb.append(i).append("\n");
	    }
	    System.out.print(sb);
	}
}
