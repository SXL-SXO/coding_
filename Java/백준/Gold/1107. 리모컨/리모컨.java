import java.io.*;
import java.util.*;
public class Main
{
    static int N, M, answer;
    static int input[], check[];
    static boolean number[] = new boolean[10];
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    M = Integer.parseInt(br.readLine());
	    
	    answer = Math.abs(N-100);
	    
	    if(M==10) {
	        System.out.print(answer);
	        return;
	    }else if(M==0){
	        answer = Math.min(answer,String.valueOf(N).length());
	        System.out.print(answer);
	        return;
	    }
	    
	    input = new int[2];
	    check = new int[2];
	    st = new StringTokenizer(br.readLine());
	    for(int i=0;i<M;i++){
	        number[Integer.parseInt(st.nextToken())] = true;
	    }
	    

        input[0] = input[1] = N;
        
        int len, num;
        for(int i=0;i<answer;i++){
            len = String.valueOf(input[0]).length();
            for(int j=check[0];j>=0;j--){
                num = (int)(input[0]%Math.pow(10,len-j)/Math.pow(10,len-j-1));
                
                if(num!=9 || j==0) {
                    check[0] = j;
                    break;
                }
            }
            for(int j=check[0];j<len;j++){
                num = (int)(input[0]%Math.pow(10,len-j)/Math.pow(10,len-j-1));
                if(number[num]) break;
                if(j==len-1) {
                    answer = Math.min(i+len, answer);
                    System.out.print(answer);
                    return;
                }
            }    
            
            len = String.valueOf(input[1]).length();
            for(int j=check[1];j>=0;j--){
                num = (int)(input[1]%Math.pow(10,len-j)/Math.pow(10,len-j-1));
                
                if(num!=0 || j==0) {
                    check[1] = j;
                    break;
                }
            }
            for(int j=check[1];j<len;j++){
                num = (int)(input[1]%Math.pow(10,len-j)/Math.pow(10,len-j-1));
                if(number[num]) break;
                if(j==len-1) {
                    answer = Math.min(i+len, answer);
                    System.out.print(answer);
                    return;
                }
            }
            
            input[0]--;
            input[1]++;
        }
	    System.out.print(answer);
	}
}
