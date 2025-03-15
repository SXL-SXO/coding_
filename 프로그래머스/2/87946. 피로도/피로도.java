// 11:51
import java.util.*;
class Solution {
    static int N, K, answer = 0;
    static boolean visit[];
    static int dungeons[][];
    public int solution(int k, int[][] dun) {
        N = dun.length;
        K = k;
        
        dungeons = dun;       
        visit = new boolean[(int)Math.pow(2, N+1)];
        
//         // 필요 피로도가 큰 순으로 처리, 같을 경우 소모 피로도가 큰 순으로 처리
//         Arrays.sort(dungeons, (o1,o2) -> o2[0]==o1[0] ? o1[1]-o2[1] : o2[0]-o1[0]);
        
//         // dp[직전 동굴 위치][현재 피로도] = 여기까지 도달가능한 경우의 수
//         // for(N) for(K) for(N) 3중 
        
//         // dp[직전 동굴 위치][이후 동굴 위치] = 갯수
//         // weight[동굴위치][동굴] = 피로도
//         // for(N) for(N) for(N) 3중 -> 갯수가 아닌 최소값에 효과적일듯
        
//         // dp[현재 피로도][현재 동굴]
//         // for(N) for(K) for(N) 3중 
        
        check(0, 0, K);
        
        return answer;
    }
    static void check(int bit, int count, int hp){
        if(visit[bit]) return;
        visit[bit] = true;
        
        answer = Math.max(count, answer);
        
        for(int i=0;i<N;i++){
            if(((bit & (1<<i)) != 0) || hp<dungeons[i][0]) continue;
            check(bit|1<<i, count+1, hp-dungeons[i][1]);
        }
    }
}