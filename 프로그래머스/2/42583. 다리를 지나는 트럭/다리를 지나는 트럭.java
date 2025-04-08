// 12:50
import java.util.*;
class Solution {
    static int N, T, W;
    static int input[];
    static Queue<Node> queue = new ArrayDeque<>();
    public int solution(int b, int weight, int[] truck_weights) {
        input = truck_weights;
        N = input.length; 
        T = b; // 걸리는 시간?
        W = weight; // 다리 위 총 합 무게 
        
        int total = 0, t = 0, idx = 0, size;
        
        for(;idx<N;t++){
            size = queue.size();
            if(size>0 && queue.peek().time<=t) {
                total -= input[queue.poll().idx];
                size--;
            }
            if(size<T && total+input[idx]<=W) {
                total += input[idx];
                queue.offer(new Node(idx++, t+T));
            }
        }
        t+=T;
        return t;
    }
    static class Node{
        int idx, time;
        Node(int idx, int time) {
            this.idx=idx;
            this.time=time;
        }
    }
}