import java.io.*;
import java.util.*;

public class 수찾기_1920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> num = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            num.put(st.nextToken(),0);

        StringBuilder sb= new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            if(num.containsKey(st.nextToken()))
                sb.append("1\n");
            else
                sb.append("0\n");   

        }
        System.out.println(sb.toString());
    }
}
