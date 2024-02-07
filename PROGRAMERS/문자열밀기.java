package 기초;

import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        List<String> aa = new ArrayList<>(Arrays.asList(A.split("")));
        List<String> bb = new ArrayList<>(Arrays.asList(B.split("")));
        System.out.println(aa);
        for(int i=0;i<aa.size();i++){
            if(aa.equals(bb)){
                if(i==0)
                    break;
                answer=aa.size()-i;
                break;
            }
            String temp=aa.get(0);
            aa.remove(0);
            aa.add(temp);
            System.out.println(aa);
            if(i==aa.size()-1)
                answer=-1;
        }
            
        return answer;
    }
}
