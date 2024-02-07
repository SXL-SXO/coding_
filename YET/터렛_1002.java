import java.util.*;
import java.io.*;

public class 터렛_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int x1,y1,r1,x2,y2,r2,aa,bb;
        int n=Integer.parseInt(br.readLine());
    
        for(int j=0;j<n;j++){
            st = new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            r1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            r2=Integer.parseInt(st.nextToken());
            
            if(r1==0&&r2==0) System.out.println("1");
            else if(r1==0 && (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)==r2*r2) System.out.println("1");
            else if(r2==0 && (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)==r1*r1) System.out.println("1");
            else if((x1-y1)*(x1-y1)+(x2-y2)*(x2-y2)==(r1+r2)*(r1+r2)) System.out.println("1");
            else if(x1==y1&&x2==y2&&r1==r2) System.out.println("-1");
            else if((x1-y1)*(x1-y1)+(x2-y2)*(x2-y2)<Math.min(r1*r1,r2*r2))
                System.out.println("0");            
            else if((x1-y1)*(x1-y1)+(x2-y2)*(x2-y2)<(r1+r2)*(r1+r2))
                System.out.println("2");

        }
    }
    
}