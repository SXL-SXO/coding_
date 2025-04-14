// 01:11

import java.util.*;
class Solution {
    static int N, answer = 0, goal = 1;
    static Node input[];
    static Stack<Integer> stack = new Stack<>();
    public int solution(int[] order) {
        N = order.length;
        input = new Node[N];
        
        for(int i=0;i<N;i++) input[i] = new Node(i+1, order[i]);
        Arrays.sort(input, (o1, o2)-> o1.b-o2.b);
        // System.out.print(Arrays.toString(input));
        for(Node i:input){
            if(i.a==goal) {
                goal++;
                answer++;
                move();
            }else stack.push(i.a);
        }
        move();
        return answer;
    }
    static void move(){
        while(!stack.isEmpty() && goal==stack.peek()){
            stack.pop();
            goal++;
            answer++;
        }
    }
    static class Node{
        int a, b;
        Node(int a, int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public String toString(){
            return this.a+" "+this.b;
        }
    }
}