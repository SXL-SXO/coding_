// 01:48~
import java.util.*;
class Solution {
    static int N, answer = 0;
    static int alpa[] = new int[26];
    public int solution(String skill, String[] skill_trees) {
        Arrays.fill(alpa, 27);
        
        char s[] = skill.toCharArray();
        N = s.length;
        for(int i=0;i<N;i++) alpa[s[i]-'A'] = i;
        
        char t[];
        int before;
        total : for(String tree : skill_trees) {
            t = tree.toCharArray();
            before = 0;
            for(char c : t){
                if(alpa[c-'A'] == 27) continue;
                else if(alpa[c-'A'] != before) continue total;
                before++;
            }
            // System.out.print(tree);
                answer++;
            
        }
        
        return answer;
    }
}