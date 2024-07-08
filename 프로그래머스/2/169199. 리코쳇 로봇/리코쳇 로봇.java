import java.util.*;
class Solution {
    static Queue<Integer> queue = new ArrayDeque<>();
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    static boolean visit[][];
    static int N, M;
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        visit = new boolean[N][M];
        
        total : for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(board[i].charAt(j)=='R') {
                    queue.offer(i*M+j);
                    break total;
                }
            }
        }
        
        int answer = 1, size, temp, ny, nx, nny, nnx;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i=0;i<size;i++){
                temp = queue.poll();
                nny = ny = temp/M;
                nnx = nx = temp%M;
                if(visit[ny][nx]) continue;
                visit[ny][nx] = true;
                for(int j=0;j<4;j++){
                    ny = temp/M;
                    nx = temp%M;
                    for(int k=0;k<Math.max(N,M);k++){
                        ny += dy[j];
                        nx += dx[j];
                        if( ny<0 || nx<0 || ny >=N || nx>=M || board[ny].charAt(nx)=='D') {
                            ny -= dy[j];
                            nx -= dx[j];                            
                            break;
                        }
                    }
                    if( ny==nny && nx==nnx ) continue;
                    if( board[ny].charAt(nx) == 'G') return answer;
                    queue.offer(ny*M+nx);
                }
            }
            answer++;
        }
        return -1;
    }
}