import java.util.*;
class Solution {
    static Map<Integer, List<Integer>> back = new HashMap<>();
    static Map<Integer, List<Integer>> front = new HashMap<>();
    static int count[] = new int[10_001];
    
    public int solution(int[] topping) {
        int answer = 0;
        for(int i=0;i<topping.length;i++){
            if(!back.containsKey(topping[i])) 
                back.put(topping[i], new ArrayList<>());                
            back.get(topping[i]).add(i);    
            count[topping[i]]++;
        }
        for(int i=0;i<topping.length;i++){
            //롤케이크 공평확인
            if(back.size() == front.size()) answer++; 
            
            //이동
            
            //- 지우기
            count[topping[i]]--;
            if(count[topping[i]]==0) back.remove(topping[i]);
            
            //- 추가하기
            if(!front.containsKey(topping[i])){
                front.put(topping[i], new ArrayList<>()); 
                front.get(topping[i]).add(i);
            }
        }
        return answer;
    }
}