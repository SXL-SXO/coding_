// 09:46~
import java.util.*;
class Solution {
    static int N;
    static int input[], answer[];
    static Set<Integer> set = new HashSet<>();
    public int[] solution(int[] numbers) {
        N = numbers.length;
        
        input = numbers;
        
        for(int i=0;i<N-1;i++) make(i);
        
        answer = new int[set.size()];
        
        int j = 0;
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) { 
			answer[j++] = iter.next();
		}
        Arrays.sort(answer);
        return answer;
    }
    static void make(int i){
        for(int j=i+1;j<N;j++) set.add(input[i]+input[j]);
    }
}