// 04:49
import java.util.*;
class Solution {
    static int N, A, answer = 0;
    static char input[];
    public int solution(String name) {
        N = name.length();
        answer = 27*N;
        
        A = 0;
        input = name.toCharArray();
        for(int i=0;i<N;i++){
            if(input[i] == 'A') A = A|(1<<i);
        }
        if(A == (1<<N)-1) return 0;
        
        make(0, 0, 0, 0, 0);
        
        return answer;
    }
    static void make(int visit_f, int visit_b, int visit, int count, int idx){
        if((visit | A) == ((1<<N) - 1)) {
            answer = Math.min(answer, count-1);
            // System.out.println(idx +" "+ count+ " "+ visit);
            return;
        }
        if(idx == N) idx = 0;
        else if(idx == -1) idx = N-1;
        
        // System.out.println(idx +" "+ count+ " "+ visit);
        if((visit&(1<<idx)) == 0) count += Math.min('Z'-input[idx]+1, input[idx]-'A');
        visit |= (1<<idx);
        
        if((visit_f & (1<<idx)) == 0) 
            make(visit_f|(1<<idx), visit_b, visit, count+1, idx+1);
        
        if((visit_b & (1<<idx)) == 0)
            make(visit_f, visit_b|(1<<idx), visit, count+1, idx-1);
        
    }
}