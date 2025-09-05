// 05:27
class Solution {
    static int N, answer = 0;
    static boolean se[], de_p[], de_m[];
    public int solution(int n) {
        N = n;
        se = new boolean[N];
        de_p = new boolean[N*2-1];
        de_m = new boolean[N*2-1];
        
        if(N==1) return 1;
        else if(N<=3) return 0;
        
        make(0);
        
        return answer;
    }
    static void make(int i){
        if(i == N) {
            answer++;
            return;
        }
        for(int j=0;j<N;j++){
            
            if(se[j] || de_p[i+j] || de_m[N-1+i-j]) continue;
            // System.out.println(i+" "+j);
            se[j] = true;
            de_p[i+j] = true;
            de_m[N-1+i-j] = true;
            make(i+1);
            se[j] = false;
            de_p[i+j] = false;
            de_m[N-1+i-j] = false;
        }
    }
}