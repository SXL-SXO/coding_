import java.util.*;
import java.io.*;

public class Main
{
    static int N, min = 1000000001, max = -1000000001;
    static int input[], count[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		count = new int[4];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) input[i] = Integer.parseInt(st.nextToken());   
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) count[i] = Integer.parseInt(st.nextToken());   
		
		cal(input[0], 1);
		
		System.out.println(max+"\n"+min);
	}
	static void cal(int res, int idx){
	    if(idx==N) {
	        min = Math.min(min, res);
	        max = Math.max(max, res);
	        return;
	    }
	    if(count[0]>0){
	        count[0]-=1;
	        cal(res+input[idx], idx+1);
	        count[0]+=1;
	    }
	    if(count[1]>0){
	        count[1]-=1;
	        cal(res-input[idx], idx+1);
	        count[1]+=1;
	    }
	    if(count[2]>0){
	        count[2]-=1;
	        cal(res*input[idx], idx+1);
	        count[2]+=1;
	    }
	    if(count[3]>0){
	        count[3]-=1;
	        cal(res/input[idx], idx+1);
	        count[3]+=1;
	    }
	}
}
