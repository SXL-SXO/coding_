import java.util.*;
import java.io.*;

public class Main
{
    static int len_a, len_b, answer = 0;
    static char a[], b[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		len_a = a.length;
		len_b = b.length;
		
		total : for(int i = 0; i<=len_a-len_b; i++){
		    if(a[i]!=b[0]) continue;
		    
		    for(int j=0; j<len_b; j++){
		        if(a[i+j]==b[j]) continue;
		        continue total;
		    }
		    answer++;
		    i+=len_b-1;
		}
		System.out.print(answer);
	}
}
