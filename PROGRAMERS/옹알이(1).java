import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] can = {"aya", "ye", "woo", "ma"};
        for (int j=0;j<babbling.length;j++){
            for(int i=0;i<4;i++){
                babbling[j]=babbling[j].replace(can[i],"_");
            }
            if(babbling[j].equals("_")||babbling[j].equals("__")||babbling[j].equals("___")||babbling[j].equals("____"))
                answer++;
        }
        return answer;
    }
}