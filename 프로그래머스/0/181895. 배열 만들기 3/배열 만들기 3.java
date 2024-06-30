import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            for(int j=intervals[i][0];j<=intervals[i][1];j++){
                answer.add(arr[j]);
            }
        }
        
        int re[] = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            re[i] = answer.get(i);
        }
        return re;
    }
}