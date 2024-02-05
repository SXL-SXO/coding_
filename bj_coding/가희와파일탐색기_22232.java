import java.io.*;
import java.util.*;
public class 가희와파일탐색기_22232 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String order[][] = new String[N][2];
        String OS[] = new String[M];
        Map<String,Integer> orderOS = new HashMap();

        for(int i=0;i<N;i++){
            order[i] = br.readLine().split("\\.");
        }
        for(int j=0;j<M;j++){
            OS[j] = br.readLine();
        }

        Arrays.sort(OS);
        for(int j=0;j<M;j++){
            orderOS.put(OS[j],j);
        }
        Arrays.sort(order, (o1, o2) -> {
            if(o1[0].equals(o2[0])){
                if(!orderOS.containsKey(o1[1]) && !orderOS.containsKey(o2[1]))
                    return o1[1].compareTo(o2[1]);
                else if(!orderOS.containsKey(o1[1]))
                    return 1;
                else if(!orderOS.containsKey(o2[1]))
                    return -1;
                return orderOS.get(o1[1])-orderOS.get(o2[1]);
            }
            return o1[0].compareTo(o2[0]);
        });

        for(int i=0;i<N;i++){
            answer.append(order[i][0]).append(".").append(order[i][1]).append("\n");
        }
        System.out.println(answer.toString());
    }
}
