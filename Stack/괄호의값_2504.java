import java.io.*;
import java.util.*;

public class 괄호의값_2504 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();

        String[] in = br.readLine().split("");
        Map<String, String> score = new HashMap<>();
        score.put("(",")");
        score.put(")","2");
        score.put("[","]");
        score.put("]","3");
        int answer = 0; //정답
        int count = 1;
        for(int i=0;i<in.length;i++){
            if(stack.size()==0) { //비어서 완전히 새로 시작하는 경우
                answer+=count;
                count=1;
                stack.push(in[i]);
                continue;
            } 

            if(in[i].equals(score.get(stack.peek()))){ //닫아가면서 원소가 빠지는 경우
                count *= Integer.parseInt(score.get(in[i]));
                stack.pop();
            }else{
                stack.push(in[i]);
            }
        }
        if(stack.isEmpty())
            System.out.println(answer+count);
        else
            System.out.println("0");
    }
}
