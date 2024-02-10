import java.io.*;
import java.util.*;

public class 제로_10773 {
    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<K;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp == 0) stack.pop();
            else stack.push(temp);
        }
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}
