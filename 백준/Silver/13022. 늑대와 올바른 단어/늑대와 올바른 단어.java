import java.util.*;
import java.io.*;
public class Main
{
    static int N, answer = 0;
    static char input[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   // StringTokenizer st = new StringTokenizer(br.readLine());
	   
	   input = br.readLine().toCharArray();
	   N = input.length;
	   
	   int count = 0;
	   total : for(int i=0;i<N+1;i++){
	       if(i==N){
	          answer = 1;
	          break;
	       }
	       if(input[i]=='w'){
	           count = 1;
	           for(int j=1;i+j<N-3;j++) {
	               if(input[i+j]!='w') {
	                   count = j;
	                   break;
	               }else if(i+j==N-3) {
	                   count = j+1;
	               }
	           }
	           //System.out.println(count);
	           for(int j=0;j<count;j++){
	               if(i+count*3+j>=N) break total;
	               else if(input[i+count+j]!='o') break total;
	               else if(input[i+count*2+j]!='l') break total;
	               else if(input[i+count*3+j]!='f') break total;
	           }
	           i += count*4-1;
	       }else break;
	    }
	    System.out.print(answer);
	}
}
