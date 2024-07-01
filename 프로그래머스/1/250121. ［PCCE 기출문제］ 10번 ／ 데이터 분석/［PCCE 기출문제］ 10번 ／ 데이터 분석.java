import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> ans = new ArrayList<>();
        
        if(sort_by.equals("code")) Arrays.sort(data, (o1,o2)-> o1[0]-o2[0]);
        else if(sort_by.equals("date")) Arrays.sort(data, (o1,o2)-> o1[1]-o2[1]);
        else if(sort_by.equals("maximum")) Arrays.sort(data, (o1,o2)-> o1[2]-o2[2]);
        else if(sort_by.equals("remain")) Arrays.sort(data, (o1,o2)-> o1[3]-o2[3]);
        
        int index;
        if(ext.equals("code")) index = 0;
        else if(ext.equals("date")) index = 1;
        else if(ext.equals("maximum")) index = 2;
        else index = 3;
        
        for(int i=0;i<data.length;i++){
            if(data[i][index]<val_ext) ans.add(data[i]);
        }
        int answer[][] = new int[ans.size()][4];
        for(int i = 0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
}