import java.io.*;
import java.util.*;

public class 집합_11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        boolean num[] = new boolean[21];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if(type.equals("all")){
                for(int j=1;j<=20;j++)
                    num[j] = true;
                continue;
            } else if(type.equals("empty")){
                for(int j=1;j<=20;j++)
                    num[j] = false;
                continue;
            } 
            int X = Integer.parseInt(st.nextToken());

            if(type.equals("add")) num[X] = true;
            else if(type.equals("remove")){
                num[X] = false;
            } else if(type.equals("toggle")){
                if(num[X]) num[X] = false;
                else num[X] = true;
            } else if(type.equals("check")){
                if(num[X]) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
