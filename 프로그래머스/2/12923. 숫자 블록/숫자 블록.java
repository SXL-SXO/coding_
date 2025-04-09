// 05:58~06:20, 07:22~
class Solution {
    static int N;
    static int answer[];
    public int[] solution(long begin, long end) {
        N = (int)(end-begin)+1;
        answer = new int[N];
        
        // 각 문자의 본인 제외, 최대약수(<=10000000) 찾기
        for(int i=0;i<N;i++) answer[i] = gcd((long)i+begin);
        return answer;
    }
    static int gcd(long num){
        if(num==1) return 0;
        
        long max = (long)Math.sqrt(num);
        for(long i=2;i<=max;i++){
            if(num%i == 0 && num/i<=10000000) return (int)(num/i);
        }
        long min = Math.min(10000000, max);
        for(long i=min; i>0;i--){
            if(num%i == 0) return (int)i;
        }
        return 1;
    }
}