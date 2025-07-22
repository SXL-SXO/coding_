// 02:09
import java.util.*;
class Solution {
    static long answer = 0;
    static int N;
    static Map<Double, Integer> map = new HashMap<>();
    public long solution(int[] weights) {
        N = weights.length;
        
        // 중복제거
        for(int i=0;i<N;i++) {
            map.put(weights[i]*1.0, map.getOrDefault(weights[i]*1.0, 0)+1);
        }
        
        long val;
        for(double key : map.keySet()) {
            val = (long) map.getOrDefault(key, 0);
            answer += val*(val-1)/2;
            answer += val*(long)map.getOrDefault(key*2, 0);
            if(key*1.5/1.5 == key) answer += val * (long)map.getOrDefault(key*1.5, 0);
            if(key*0.75/0.75 == key) answer += val * (long)map.getOrDefault(key*0.75, 0);
            
            // System.out.print(key/1.5*1.5 == key);
            // System.out.print(key/0.75*0.75 == key);
            // System.out.println(val+" "+key+" "+key*1.5+" "+key*0.75+" "+answer);
        }
        
        return answer;
    }
    static class Node{
        int idx, val;
        Node(int idx, int val){
            this.idx=idx;
            this.val=val;
        }
    }
}