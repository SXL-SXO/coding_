// 02:37~
import java.util.*;
class Solution {
    // 5개 사이즈 옮기기(1-3) -> 4개 옮기기(1-2) + 1->3 + 4개옮기기(2-3);
    static List<int[]> list = new ArrayList<>();
    static int N;
    public int[][] solution(int n) {
        move(n, 1, 3);
        N = list.size();
        int answer[][] = new int[N][2];
        for(int i=0;i<N;i++) answer[i] = list.get(i);
        return answer;
    }
    
    static void move(int size, int start, int end){
        if(size == 1){
            list.add(new int[]{start, end});
            return;
        }
        
        move(size-1, start, 6-start-end);
        list.add(new int[]{start, end});
        move(size-1, 6-end-start, end);
    }
}