// 07:54
class Solution {
    static int N, answer = 0;
    static int input[], dp[][];
    public int solution(int[] money) {
        N = money.length;
        input = money;
        
        dp = new int[2][N];
        
        if(N==3) return Math.max(Math.max(input[0], input[1]), input[2]);
        
        dp[0][0] = 0;
        dp[1][0] = input[0];
        
        dp[0][1] = input[1];
        dp[1][1] = input[0];
        
        for(int i=2;i<N;i++){
            dp[0][i] = Math.max(dp[0][i-2]+input[i], dp[0][i-1]);
            dp[1][i] = Math.max(dp[1][i-2]+input[i], dp[1][i-1]);
        }
        answer = Math.max(dp[0][N-1], dp[1][N-2]);
        
        return answer;
    }
}