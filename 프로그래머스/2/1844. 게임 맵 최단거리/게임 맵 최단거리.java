// 06:48~
import java.util.*;
class Solution {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean visit[][];
    static int N, M;
    public int solution(int[][] input) {
        N = input.length;
        M = input[0].length;
        visit = new boolean[N][M];
        
        queue.offer(0);
        int answer = 0, temp, size, ny, nx;
        total : while(!queue.isEmpty()){
            answer++;
            size = queue.size();
            for(int i=0;i<size;i++){
                temp = queue.poll();
                if(temp == N*M-1) return answer;
                for(int j=0;j<4;j++){
                    ny = temp/M+dy[j];
                    nx = temp%M+dx[j];
                    if(ny<0||ny>=N||nx<0||nx>=M||input[ny][nx]==0||visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                    queue.offer(ny*M+nx);
                }
            }
        }
        
        return -1;
    }
}