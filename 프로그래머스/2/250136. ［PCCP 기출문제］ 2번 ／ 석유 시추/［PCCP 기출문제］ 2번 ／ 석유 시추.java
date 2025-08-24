// 02:46
import java.util.*;
class Solution {
    static int N, M, answer = 0;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int input[][];
    static boolean visit[];
    static List<Integer> list = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        
        input = land;
        
        list.add(0);
        
        int idx = 1, count;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j] == 1) list.add(check(idx++, i*M+j));
            }
            // System.out.println(Arrays.toString(input[i]));
        }
        
        visit = new boolean[idx];
        for(int j=0;j<M;j++){
            Arrays.fill(visit, false);
            count = 0;
            
            for(int i=0;i<N;i++){
                if(input[i][j]<0 && !visit[-input[i][j]]){
                    visit[-input[i][j]] = true;
                    count += list.get(-input[i][j]);
                }
            }
            
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    static int check(int idx, int where){
        int temp, ny, nx, count = 0;
        
        queue.offer(where);
        input[where/M][where%M] = -idx;
        
        while(!queue.isEmpty()){
            temp = queue.poll();
            count++;
            
            for(int i=0;i<4;i++){
                ny = temp/M + dy[i];
                nx = temp%M + dx[i];
                
                if(ny<0 || ny>=N || nx<0 || nx>=M || input[ny][nx]!=1) continue;
                input[ny][nx] = -idx;
                queue.offer(ny*M+nx);
            }
        }
        
        return count;
    }
}