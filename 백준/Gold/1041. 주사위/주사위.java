import java.util.*;
import java.io.*;
public class Main
{
    static int N, sum_rd=151, sum_nd=101, sum_st=51;
    static long answer = 0;
    static int input[];
    static int dp[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    input = new int[6];
    
        st = new StringTokenizer(br.readLine());
	    for(int i=0;i<6;i++){
	        input[i] = Integer.parseInt(st.nextToken());
	        sum_st = Math.min(sum_st, input[i]);
	    }
	    
	    if(N==1){
	        int answer = 0, max = input[0];
	        for(int i=0;i<6;i++) {
	            answer += input[i];
	            max = Math.max(max, input[i]);
	        }
	        System.out.print(answer-max);
	        return;
	    }
	    
	    for(int i=0;i<5;i++) sum(i, 1, 1<<i, input[i]);
	    
	    answer = (long)5*N*N - (long)8*(N-1) - (long)8*(N-2) - (long)12;
	    answer *= (long)sum_st;
	    answer += (long)sum_nd*4*(N-1);
	    answer += (long)sum_nd*4*(N-2);
	    answer += (long)sum_rd*4;
	    
	    System.out.print(answer);
	}
	static void sum(int idx, int count, int bit, int total){
	    // 안되는 조합 05 14 23
	    if(!check(bit) || idx>6 || count>3) return;
	    else if(count==2){
	        sum_nd = Math.min(sum_nd, total);
	    }else if(count==3){
	        sum_rd = Math.min(sum_rd, total);
	        return;
	    }
	    
	    for(int i=idx+1;i<6;i++) sum(i, count+1, (bit|(1<<i)), total+input[i]);
	}
	static boolean check(int bit){
	    if((bit&(1<<0))!=0 && (bit&(1<<5))!=0) return false;
	    else if((bit&(1<<1))!=0 && (bit&(1<<4))!=0) return false;
	    else if((bit&(1<<2))!=0 && (bit&(1<<3))!=0) return false;
        return true;
	}
}
