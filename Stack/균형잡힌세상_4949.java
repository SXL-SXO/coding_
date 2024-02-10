import java.io.*;
import java.util.*;

public class 균형잡힌세상_4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        char in_put_[] = input.toCharArray();
        while(!(input.charAt(0)=='.'&&input.length()==1)){
            Deque<Character> stack = new ArrayDeque<>();
            int size = sb.length();
            for(char c : in_put_){ 
                // 다른 입력이면 넘어감
                if(c!='[' && c!='(' && c!=']' && c!=')') continue;

                // 시작이어도 넣고 넘어감
                if(c=='[' || c=='(') stack.push(c);

                // 끝일때 스택 안에 있는 값과 짝꿍이 아니면 에러
                else if(!stack.isEmpty()){
                    if(c==']' && '['==stack.peek()) stack.pop();
                    else if(c==')' && '('==stack.peek()) stack.pop();
                    else{
                        sb.append("no").append("\n");
                        break;
                    }

                // 끝일때 스택이 비었으면 짝꿍이 없는거면 에러
                }else{
                    sb.append("no").append("\n");
                    break;
                }
            }
            //다 돌았는데, stack이 0이 아니면 에러 
            if(size==sb.length()){
                if(stack.size()==0) sb.append("yes").append("\n");
                else sb.append("no").append("\n");
            }
            
            input = br.readLine();
            in_put_ = input.toCharArray();
        }
        System.out.println(sb.toString());
    }   
}
