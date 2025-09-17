import java.util.*;
import java.io.*;
public class Main
{
    static int T, N;
    static long min[];
    static String max[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    max = new String[101];
	    max[2] = "1";
	    max[3] = "7";
	    
	    for(int i=4;i<=100;i++) max[i] = max[i-2]+"1";
	    
	    min = new long[101];
	    min[2] = 1;
	    min[3] = 7;
	    min[4] = 4;
	    min[5] = 2;
	    min[6] = 6;
	    min[7] = 8;
	    min[8] = 10;
	    
	    int ten[] = new int[6];
	    ten[1] = 1;
	    ten[2] = 1;
	    ten[3] = 1;
	    ten[4] = 1;
	    ten[5] = 1;
	    
	    long se, si, fi, fo, th, tw;
	    for(int i=9;i<=100;i++){
	        for(int j=0;j<5;j++) ten[j] = ten[j+1];
	        ten[5] = cal(min[i-2]);
	        
	        se = Math.min(min[i-7]*10+8, (long)Math.pow(10, ten[0])*8+min[i-7]);
	        si = Math.min(min[i-6]*10, (long)Math.pow(10, ten[1])*6+min[i-6]);
	        fi = Math.min(min[i-5]*10+2, (long)Math.pow(10, ten[2])*2+min[i-5]);
	        fo = Math.min(min[i-4]*10+4, (long)Math.pow(10, ten[3])*4+min[i-4]);
	        th = Math.min(min[i-3]*10+3, (long)Math.pow(10, ten[4])*3+min[i-3]);
	        tw = Math.min(min[i-2]*10+1, (long)Math.pow(10, ten[5])+min[i-2]);
	        
	        min[i] = Math.min(Math.min(th, tw), Math.min(Math.min(fi, fo), Math.min(se, si)));
	    }
	    
	    T = Integer.parseInt(br.readLine());
	    for(int t=0; t<T; t++){
	        N = Integer.parseInt(br.readLine());
	        
	        sb.append(min[N]).append(" ").append(max[N]).append("\n");
	    }
	    
	    System.out.print(sb);
	}
	static int cal(long n){
	    int cnt = 0;
	    while(n>0){
	        n/=10;
	        cnt++;
	    }
	    return cnt;
	}
}
