import java.io.*;
import java.util.*;

public class 괄호의값_2504 {
    static int answer = 0;
    static char[] in;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine().toCharArray();
        
        int temp = 1, answer = 0;
        for(int i=0;i<in.length;i++){
            if(in[i]=='('){
                temp*=2;
                stack.push(in[i]);
            }else if(in[i]=='['){
                temp*=3;
                stack.push(in[i]);
            }else if(stack.isEmpty()){
                answer = 0;
                break;
            }else{
                if(in[i]==')' && stack.peek()=='('){
                    stack.pop();
                    if(in[i-1]=='(') answer += temp;
                    temp /= 2;
                }else if(in[i]==']'&& stack.peek()=='['){
                    stack.pop();
                    if(in[i-1]=='[') answer += temp;
                    temp /= 3;
                }else{
                    answer = 0;
                    break;
                }
            }
        }
        if(!stack.isEmpty()) answer = 0;
        System.out.println(answer);
    }


    // 틀린 나의 생각

    // static int check(int Idx){
    //     Stack<Integer> score = new Stack<>();
    //     int temp = 0;
    //     if(in[Idx]=='(' || in[Idx]=='['){
    //         stack.push(in[Idx]+"");
    //         temp += score.push(check(Idx+1));
    //     }else if(stack.isEmpty()){
    //         stack.push(in[Idx]+"");
    //         return -1;
    //     }else if(in[Idx]==']'){
    //         while(!score.isEmpty()){
    //             temp *= score.pop();
    //         }
    //     }else if(in[Idx]==')'){
    //         stack.push(null)
    //     }
    // }
}
