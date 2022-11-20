import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        Arrays.sort(dots, new Comparator<int[]>(){
            @Override
                public int compare(int[] o1, int[] o2){
                    return o1[0]-o2[0];
                }
        });
        int garo=0,sero=0;
        garo=Math.abs(dots[0][0]-dots[2][0]);
        sero=Math.abs(dots[0][1]-dots[1][1]);
        answer=garo*sero;
        return answer;
    }
}