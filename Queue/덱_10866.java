package my_study;

import java.io.*;
import java.util.*;

public class 덱_10866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input[];
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<N;i++){
            input = br.readLine().split(" ");
            switch (input[0]) {
                case "push_front" : stack.push(Integer.parseInt(input[1])); break;
                case "push_back" : stack.offer(Integer.parseInt(input[1])); break;
                case "pop_front" : ans.append( stack.isEmpty() ? -1 : stack.pop()).append("\n") ; break;
                case "pop_back" : ans.append( stack.isEmpty() ? -1 : stack.pollLast()).append("\n") ; break;
                case "empty" : ans.append(stack.isEmpty() ? 1 : 0).append("\n"); break;
                case "size" : ans.append(stack.size()).append("\n"); break;
                case "front" : ans.append( stack.isEmpty() ? -1 : stack.peek()).append("\n") ; break;
                case "back" : ans.append( stack.isEmpty() ? -1 : stack.peekLast()).append("\n") ; break;
            }
        }
        System.out.println(ans.toString());
    }
}
