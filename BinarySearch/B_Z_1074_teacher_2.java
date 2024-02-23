package feb_14;

import java.io.*;
import java.util.*;

public class B_Z_1074_teacher_2 {
	static int N, r, c, ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        N = (int)Math.pow(2, N);
        
        int y=0, x=0; 
        ans=0;
        
        Z(0,0);	
	}
	static void Z(int y, int x) {
		if(N==1) return;
		N = N /=2;
    	//4가지 영역별로 자르고  r, c가 어디에 잇는지
    	if(r<y+N && c<x+N) Z(y,x); // top-left
    	else if(r<y+N) {// top-right 이득보고 시작점이동
    		ans+=N*N*1;
    		Z(y,x+N);;
    	}else if(c<x+N) {// bottom-left 이득보고 시작점이동
    		ans+=N*N*2;
    		Z(y+N,x);
    	}else {
    		ans+=N*N*3;
    		Z(y+N,x+N);
    	}
	}
}
