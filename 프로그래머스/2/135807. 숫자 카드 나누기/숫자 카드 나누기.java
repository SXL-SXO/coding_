// 01:06

// 한 집단에서 공배수이자 다른 집단에선 서로소 관계인 
import java.util.*;
class Solution {
    static int A[], B[];
    static int N, M, max, answer = 0;
    public int solution(int[] arrayA, int[] arrayB) {
        A = arrayA;
        B = arrayB;
        N = A.length;
        M = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        max = Math.max(A[N-1], B[M-1]); 
        
        for(int i=2;i<=max;i++){
            if(all_div(i, true) && all_not_div(i, false)) answer = i;
            else if(all_div(i, false) && all_not_div(i, true)) answer = i;
        }
        
        return answer;
    }
    static boolean all_div(int num, boolean type){
        if(type){
            for(int i=0;i<N;i++) if(A[i] % num != 0) return false;
        }else{
            for(int i=0;i<M;i++) if(B[i] % num != 0) return false;
        }
        return true;
    }
    static boolean all_not_div(int num, boolean type){
        if(type){
            for(int i=0;i<N;i++) if(A[i] % num == 0) return false;
        }else{
            for(int i=0;i<M;i++) if(B[i] % num == 0) return false;
        }
        return true;
    }
}