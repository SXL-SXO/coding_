import java.io.*;

public class 팩토리얼0의개수_1676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=1;i<=N;i++){
            int num = i;
            while(true){
                if(num%5!=0) break;
                answer+=1;
                num=num/5;
            }
        }
        System.out.println(answer);
    }
}
