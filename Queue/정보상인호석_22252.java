import java.io.*;
import java.util.*;

public class 정보상인호석_22252 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        long answer = 0;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int code = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            // 상인이 정보 새로 가지고 왔을때
            if (code == 1) {
                for (int j = 0; j < count; j++) {
                    if (!map.containsKey(name)) {

                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.add(Integer.parseInt(st.nextToken()));
                        map.put(name, pq);
                    } else
                        map.get(name).add(Integer.parseInt(st.nextToken()));

                }
            } else {
                if (map.get(name) == null)
                    continue;
                while (!map.get(name).isEmpty() && count > 0) {
                    answer += map.get(name).poll();
                    count--;
                }
            }

        }
        System.out.println(answer);
    }
}
