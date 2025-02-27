// 시작 시간 06시 40분
import java.util.*;

class Solution {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0 ,1, 0, -1};
    static boolean visit[][];
    static char map[][];
    static int n, m, answer = 0;
    static Node S, L; 
    static Queue<Node> queue = new ArrayDeque<>();
    public int solution(String[] maps) {        
        n = maps.length;
        m = maps[0].length();
        visit = new boolean[n][m];
        map = new char[n][];
        
        for(int i=0;i<n;i++){
            map[i] = maps[i].toCharArray();
            for(int j=0;j<m;j++) {
                if(map[i][j]=='S') S = new Node(i, j);
                else if(map[i][j]=='L') L = new Node(i, j);
            }
        }
        ;
        if(!check(S, 'L')) return -1;
        if(!check(L, 'E')) return -1;
            
        return answer;
    }
    static boolean check(Node start, char goals){
        Node temp;
        int ny, nx, count = 1, size;
        visit = new boolean[n][m];
        visit[start.y][start.x] = true;
        
        queue.clear();
        queue.offer(start);
        
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i=0;i<size;i++){
                temp = queue.poll();
                for(int j=0;j<4;j++) {
                    ny = temp.y+dy[j];
                    nx = temp.x+dx[j];
                    
                    if(ny<0 || ny>=n || nx<0 || nx>=m || visit[ny][nx]) continue;
                    
                    visit[ny][nx] = true;
                    
                    if(map[ny][nx] == 'X') continue;
                    else if(map[ny][nx] == goals) {
                        answer += count;
                        return true;
                    }
                    queue.offer(new Node(ny, nx));
                }
            }
            count++;
        }
        return false;
    }
    static class Node{
        int y, x;
        Node(int y, int x){
            this.y=y;
            this.x=x;
            
        }
    }
}