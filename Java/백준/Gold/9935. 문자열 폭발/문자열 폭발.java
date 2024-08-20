import java.util.*;
import java.io.*;

public class Main
{
    static String bomb;
    static char input[];
    static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder temp = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();
        bomb = br.readLine();

        int len_b = bomb.length(), len_i = input.length;
        
        for(int j=0;j<len_i;j++) {
            stack.push(input[j]);
            if(stack.size()<len_b || stack.peek() != bomb.charAt(len_b-1)) continue;
            
            temp.setLength(0);
            
            for(int i=len_b-1;i>=0;i--){
                temp.append(stack.pop());
            }
            
            temp.reverse();
            if(!bomb.equals(temp.toString())) {
                for(int i=0;i<temp.length();i++){
                    stack.push(temp.charAt(i));
                }
            }
        }
        
        if(stack.size() == 0) sb.append("FRULA");
        else{
            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            sb.reverse();
        }
        System.out.print(sb);
    }
}