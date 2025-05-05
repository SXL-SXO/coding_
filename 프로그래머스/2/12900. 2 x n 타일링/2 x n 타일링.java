// 10:05
class Solution {
    static int N, answer;
    static int dp[];
    public int solution(int n) {
        N = n;
        
        if(n==1) {
            answer = 1;
        }else if(n==2){
            answer = 2;
        }else{
            dp = new int[N+1];
            
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3;i<=N;i++){
                dp[i] = dp[i-2]%1000000007 + dp[i-1]%1000000007;
                dp[i] %= 1000000007;
            }
            answer = dp[N];
        }
        return answer;
    }
}