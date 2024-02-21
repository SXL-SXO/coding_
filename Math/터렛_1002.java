import java.util.*;
import java.io.*;

public class 터렛_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int x1,y1,r1,x2,y2,r2;
        double r;
        int n=Integer.parseInt(br.readLine());
    
        for(int j=0;j<n;j++){
            st = new StringTokenizer(br.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            r1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());
            r2=Integer.parseInt(st.nextToken());
            
            //백과 조의 거리
            r = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
            //안에 포함된 경우 
            if(r1==r2 && r==0) sb.append(-1);
            else if(r+Math.min(r1,r2)<Math.max(r1,r2)||r1+r2<r) sb.append(0);
            else if(r+Math.min(r1,r2)==Math.max(r1,r2)||r1+r2==r) sb.append(1);
            else if(r1+r2>r)sb.append(2);
            sb.append("\n");
        }   
        System.out.println(sb.toString());
    }
    
}