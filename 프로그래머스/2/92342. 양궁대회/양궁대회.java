// 12:03~
import java.util.*;
class Solution {
    static int apach[], answer[] = new int[11];
    static int N, M, diff = 0;
    public int[] solution(int n, int[] info) {
        N = n;
        M = 11;
        
        apach = info;
        for(int i=M-1;i>=0;i--){
            make(i, 1<<i, apach[i]+1);
        }
        
        if(diff == 0) answer = new int[]{-1};
        return answer;
    }
    static void make(int idx, int visit, int used){
        if(used>N) return;
        
        int score_l = 0, score_a = 0;
        for(int i=M-1;i>=0;i--) {
            if((visit & (1<<i)) != 0) score_l += 10-i;
            else if(apach[i] > 0) score_a += 10-i;
        }

        if(score_l-score_a > diff){
            diff = score_l-score_a;
            answer[M-1] = N-used;
            for(int i=M-2;i>=0;i--) {
                if((visit & (1<<i)) != 0) answer[i] = apach[i]+1;
                else answer[i] = 0;
            }
        }
        
        for(int i=idx-1;i>=0;i--){
            make(i, visit | (1<<i), used+apach[i]+1);
        }         
        
    }
}