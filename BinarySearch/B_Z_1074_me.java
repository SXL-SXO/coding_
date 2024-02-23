package feb_14;

import java.io.*;
import java.util.*;

public class B_Z_1074_me {
    static int r, c;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(Z(0,0,N));
    }
    static int Z(int start_r, int start_c, int N){
        if(N==0){ 
            if(start_c-c==0&&start_r-r==0) return 0;
            else if(start_c-c==0) return 1;
            else if(start_r-r==0) return 2;
            else return 3;
        }int po = (int)Math.pow(2,N-1);
        //System.out.println((start_r+po)+ " "+ (start_c+po)+" "+N);
        if(start_c+po>c && start_r+po>r) 
            return Z(start_r, start_c, N-1);
        else if(start_r+po>r) 
            return Z(start_r, start_c+po, N-1)+po*po;
        else if(start_c+po>c)
            return Z(start_r+po, start_c, N-1)+po*po*2;
        else
            return Z(start_r+po, start_c+po, N-1)+po*po*3;
    }
}