import java.io.*;
import java.util.*;

public class Main {
    static int T, n, m;
    static int A[];
    static List<Node> list;
    static StringBuilder sb = new StringBuilder();
    static Long answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            A = new int [n];
            answer = 0L;
            list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                A[i] = Integer.parseInt(st.nextToken());
                list.add(new Node(A[i], true));
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                list.add(new Node(Integer.parseInt(st.nextToken()),false));
            }

            Collections.sort(list, (o1,o2)-> o1.a-o2.a);

            for(int i=0;i<list.size();i++){
                if(!list.get(i).type) continue;
                int front = -1000000001, back = 2000000001; 
                for(int j=i-1;j>-1;j--){
                    if(list.get(j).type) continue;
                    front = list.get(j).a;
                    break;
                }
                for(int j=i+1;j<list.size();j++){
                    if(list.get(j).type) continue;
                    back = list.get(j).a;
                    break;
                }
                answer += list.get(i).a - front <= back- list.get(i).a ? front : back ;
            }   
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Node {
        int a;
        boolean type;

        Node(int a, boolean type) {
            this.a = a;
            this.type = type;
        }

    }
}
