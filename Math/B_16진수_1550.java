import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_16진수_1550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char input[] = br.readLine().toCharArray();
        int answer = 0;
        for(int i=0;i<input.length;i++){
            int a;
            if(input[i]>='0'&&input[i]<='9') a = input[i]-'0';
            else a = 10 + (input[i]-'A');
            answer += Math.pow(16, input.length-1-i)*a;
        }
        System.out.println(answer);

    }
}
