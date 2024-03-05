import java.io.*;
import java.util.*;
public class B_패션왕신해빈_9375 {
    static int T, N, answer;
    static Map<String, List<String>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            answer = 1;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String what = st.nextToken();
                String type = st.nextToken();
                if(!map.containsKey(type)) 
                    map.put(type, new ArrayList<>());
                map.get(type).add(what);
            }

            for(String key : map.keySet()){
                answer *= (map.get(key).size()+1);
            }
            if(N == 0) sb.append("0\n");
            else sb.append(answer-1).append("\n");
        }
        System.out.println(sb);
    }
}
