// 12:55
import java.util.*;
class Solution {
    static int N, answer = 1;
    public int solution(int[][] routes) {
        N = routes.length;
        Arrays.sort(routes, (o1, o2) -> o1[1]==o2[1] ? o2[0]-o1[0] : o2[1]-o1[1]);
        
        int temp = routes[0][0];
        for(int i=1;i<N;i++){
            if(routes[i][1] < temp) {
                answer++;
                temp = routes[i][0];
            }else temp = Math.max(temp, routes[i][0]);
            // System.out.print(temp+" ");
        }
        
        return answer;
    }
}