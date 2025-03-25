// 02:06~
import java.util.*;

class Solution {
    static int N, T;
    static int num[];
    public int solution(int[] numbers, int target) {
        N = numbers.length;
        T = target;
        num = numbers;
        return cal(1, num[0]) + cal(1, -num[0]);
    }
    static int cal(int idx, int val){
        if(idx == N){
            if(val==T) return 1;
            else return 0;
        }
        return cal(idx+1, val+num[idx]) + cal(idx+1, val-num[idx]);
    }
}