import java.io.*;
public class B_AC_5430 {
    static int T,N,front,back;
    static boolean type; //앞은 true, 뒤는 back
    static char todo[];
    static String num[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            type = true;
            todo = br.readLine().toCharArray();
            N = Integer.parseInt(br.readLine());
            front = 0;
            back = N;
            num = br.readLine().split(",");
            num[0] = num[0].replace("[", "");
            num[num.length-1] = num[num.length-1].replace("]", "");
            for(char c : todo){
                if(c=='R') {
                    type=!type;
                    continue;
                }
                if(type) front += 1;
                else back -= 1;
                if(front>back) break;
            }
            if(front>back) sb.append("error").append("\n");
            else{
                sb.append("[");
                if(type){
                    for(int i=front;i<back;i++){
                        sb.append(num[i]).append(",");
                    }
                }else{
                    for(int i=back-1;i>=front;i--){
                        sb.append(num[i]).append(",");
                    }
                }
                if(front!=back) sb.setLength(sb.length()-1);
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}
