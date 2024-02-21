import java.io.*;
import java.util.*;

public class 비밀번호찾기_17219 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String,String> password = new HashMap<>();
        for(int i = 0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            password.put(st.nextToken(), st.nextToken());
        }
        for(int i = 0;i<M;i++){
            sb.append(password.get(br.readLine())).append("\n");
        }
        System.out.println(sb.toString());
    }
}
