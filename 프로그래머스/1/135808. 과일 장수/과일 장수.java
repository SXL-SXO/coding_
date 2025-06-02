// 05:07
import java.util.*;

class Solution {
    static int N, answer = 0;
    public int solution(int k, int m, int[] score) {
        N = score.length;
        Arrays.sort(score);
        
        for(int i=N%m; i<N; i+=m){
            answer += score[i]*m;
        }
        
        return answer;
    }
}