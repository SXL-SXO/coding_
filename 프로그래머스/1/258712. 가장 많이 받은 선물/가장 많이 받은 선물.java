//01:32

import java.util.*;
class Solution {
    static int N, answer = 0;
    static Map<String, Integer> present = new HashMap<>();
    static Map<String, Integer> give = new HashMap<>();
    static Map<String, Integer> get = new HashMap<>();
    static Map<String, Integer> map = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        N = friends.length;
        
        for(String f : friends) {
            present.put(f, 0);
            give.put(f, 0);
            get.put(f, 0);
        }
        
        String temp[];
        for(String g : gifts) {
            temp = g.split(" ");
            map.put(g, map.getOrDefault(g, 0)+1);
            give.put(temp[0], give.get(temp[0])+1);
            get.put(temp[1], get.get(temp[1])+1);
        }
        
        StringBuilder sb = new StringBuilder();
        int A, B, C;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                sb.setLength(0);
                sb.append(friends[i]).append(" ").append(friends[j]);
                A = map.getOrDefault(sb.toString(), 0);
                
                sb.setLength(0);
                sb.append(friends[j]).append(" ").append(friends[i]);
                B = map.getOrDefault(sb.toString(), 0);
                
                if(A>B) present.put(friends[i], present.get(friends[i])+1);
                else if(A<B) present.put(friends[j], present.get(friends[j])+1);
                else {
                    C = give.get(friends[i])-get.get(friends[i]) - give.get(friends[j])+get.get(friends[j]);
                    if(C>0) present.put(friends[i], present.get(friends[i])+1);
                    else if(C<0) present.put(friends[j], present.get(friends[j])+1);
                }
            }
        }
         
        for(String s : present.keySet()) {
            // System.out.println(s+" "+present.get(s));
            answer = Math.max(answer, present.get(s));
        }
            
        return answer;
    }
}