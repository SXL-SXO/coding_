import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main{
    static int T, K, N;
    static char input[];
    static List<List<Integer>> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<26;i++){
            list.add(new ArrayList<>());
        }
        int length_s, length_b;
        for(int t=0;t<T;t++){
            input = br.readLine().toCharArray();
            N = input.length;
            K = Integer.parseInt(br.readLine());
            if(K==1){
                sb.append(1).append(" ").append(1).append("\n");
                continue;
            }

            for(int i=0;i<26;i++){
                list.get(i).clear();
            }
            // 알파벳별로 입력
            for(int i=0;i<N;i++){
                list.get(input[i]-'a').add(i);
            }

            // 알파벳별로 정확히 K만큼 있을떄 최소값 구하기
            length_s = N;
            length_b = -1;
            for(int i=0;i<26;i++){
                for(int j=0;j+K-1<list.get(i).size();j++){
                    length_s = Math.min(list.get(i).get(j+K-1)-list.get(i).get(j), length_s);
                    length_b = Math.max(list.get(i).get(j+K-1)-list.get(i).get(j), length_b);
                }
            }

            if(length_b == -1 || length_s == N) sb.append(-1).append("\n");
            else sb.append(length_s+1).append(" ").append(length_b+1).append("\n");
        }
        System.out.println(sb);
    }

}