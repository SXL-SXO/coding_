import java.util.*;
class Solution {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    public int solution(String[][] board, int h, int w) {        
        int answer = 0, n = board.length, ny, nx;
    
        for(int i=0;i<4;i++){
            ny = h+dy[i];
            nx = w+dx[i];
            if(ny>=n || ny<0 || nx>=n || nx<0 || !board[ny][nx].equals(board[h][w])) continue;
            answer++;
        }
        
        return answer;
    }
}