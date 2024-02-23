package feb_14;

import java.io.*;
import java.util.*;

public class B_Z_1074_teacher_1 {
	static int N, r, c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        N = (int)Math.pow(2, N);
        
        int y=0, x=0, ans=0;
       
        
        while(true) {
        	if(N==1) break;
        	N = N /=2;
        	//4가지 영역별로 자르고  r, c가 어디에 잇는지
        	if(r<y+N && c<x+N) continue; // top-left
        	else if(r<y+N) {// top-right 이득보고 시작점이동
        		ans+=N*N*1;
        		x+=N;
        	}else if(c<x+N) {// bottom-left 이득보고 시작점이동
        		ans+=N*N*2;
        		y+=N;
        	}else {
        		ans+=N*N*3;
        		x+=N;
        		y+=N;
        	}
        }
        System.out.print(ans);
	}
}
