// 06:08
import java.util.*;
class Solution {
    static int N, M;
    static long answer;
    static int input[];
    public long solution(int n, int[] times) {
        M = n;
        input = times;
        N = input.length;
        Arrays.sort(input);
        
        make();
        
        return answer;
    }
    static void make(){
        long hi = 1_000_000_000_000_000_001L, lo = 0, mid;
        
        // FFFFFTTTTTTTT
        while(lo < hi-1){
            
            mid = (lo+hi)/2;
            // System.out.println(lo+" "+hi+" "+mid);
            
            if(!check(mid)) lo = mid;
            else hi = mid;
        }
        
        answer = hi;
    }
    static boolean check(long val){
        long sum = 0;
        
        for(int i : input) sum += val/(long)i;
        
        if(sum < M) return false;
        return true;        
    }
}