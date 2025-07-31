// 05:49~
import java.util.*;
class Solution {
    static int N, M, answer;
    static long num;
    static long sum[];
    public int solution(int[] queue1, int[] queue2) {
        N = queue1.length;   
        M = N*2;
        answer = M*2+1;
        sum = new long[M+1];
        
        sum[1] = queue1[0];
        for(int i=1;i<N;i++) sum[i+1] = sum[i] + queue1[i];
        for(int i=0;i<N;i++) sum[N+i+1] = sum[N+i] + queue2[i];
        
        num = sum[M]/2;
        if(num*2 != sum[M]) return -1;
        
        int idx1, idx2;
        idx2 = search(num);
        for(;idx2<M;idx2++){
            idx1 = search(sum[idx2]-num);
            if(sum[idx2]-sum[idx1] == num) {
                // System.out.print(idx1+" "+idx2);
                if(idx2<N) answer = Math.min(answer, idx2+N+idx1);
                else if(idx2==N) answer = Math.min(answer, idx1);
                else answer = Math.min(answer, idx1+idx2-N);
            }
        }
        if(answer == M*2+1) answer = -1;
        return answer;
    }
    static int search(long res){
        int lo = -1, hi = 2*N+1, mi;
        
        while(lo+1<hi){
            mi = (lo+hi)/2;
            
            // FFFFTTTT
            if(!check(mi, res)) lo = mi;
            else hi = mi;
        }
        return hi;
    }static boolean check(int idx, long res){
        if(sum[idx] >= res) return true;
        return false;
    }
    // 이분탐색 -> 불가
    // 누적합 -> 애매 (for 두번)
    // 누적합 + 이분탐색 ->
}