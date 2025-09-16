// 10:14
import java.util.*;
class Solution {
    static int input[][];
    static boolean visit[][];
    static int N, M, answer = 0;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static Queue<Integer> queue = new ArrayDeque<>();
    public int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        answer = N*M;
        
        input = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                input[i][j] = (int)storage[i].charAt(j);
            }
        }
        for(int i=0;i<N;i++){
            visit[i][0] = true;
            visit[i][M-1] = true;
        }
        for(int j=0;j<M;j++){
            visit[0][j] = true;
            visit[N-1][j] = true;
        }
        
        for(String r : requests){
            if(r.length() == 2) deleteAll((int)r.charAt(0));
            else deletePart((int)r.charAt(0));
            make();
            
            
            // for(int i=0;i<N;i++) {
            //     System.out.println(Arrays.toString(input[i]));
            // }
            // System.out.println("====");
        }
        return answer;
    }
    static void make(){
        boolean change;
        int temp, y, x, ny, nx, size;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int s = 0; s<size; s++){
                temp = queue.poll();
                y = temp/M;
                x = temp%M;
                if(!visit[y][x]) {
                    queue.offer(temp);
                    continue;
                }
                    
                change = false;
                for(int i=0;i<4;i++){
                    ny = y + dy[i];
                    nx = x + dx[i];

                    if(ny<0||ny>=N||nx<0||nx>=M||visit[ny][nx]) continue;
                    visit[ny][nx] = true;
                }
            }
            if(size == queue.size()) return;
        }
    }
    static void deletePart(int x){
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j] == x && visit[i][j]) {
                    queue.offer(i*M+j);
                    input[i][j] = 0;
                    answer--;
                }
            }
        }
    }
    static void deleteAll(int x){
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++){
                if(input[i][j]==x) {
                    queue.offer(i*M+j);
                    input[i][j] = 0;
                    answer--;
                }
            }
        }
    }
}