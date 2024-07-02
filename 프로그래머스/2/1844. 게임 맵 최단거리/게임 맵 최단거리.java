import java.util.*;
class Solution {
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static boolean visit[][];
    static Queue<Integer> queue = new ArrayDeque<>();
    public int solution(int[][] maps) {
        int N = maps.length, M = maps[0].length;
        visit = new boolean[N][M];
        
        int answer = 0, ny, nx, size, temp;
        
        queue.offer(0);
        visit[0][0] = true;
        
        while(!queue.isEmpty()){
            size = queue.size();
            answer++;
            for(int i=0;i<size;i++){
                temp = queue.poll();
                if(temp == N*M-1) {
                    return answer;
                }
                for(int j=0;j<4;j++){
                    ny = dy[j]+temp/M;
                    nx = dx[j]+temp%M;
                    if(ny>=N||ny<0||nx>=M||nx<0||maps[ny][nx]==0||visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                    queue.offer(ny*M+nx);
                }
            }
        }
        return -1;
    }
}