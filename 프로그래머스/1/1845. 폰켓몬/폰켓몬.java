// 04:13
import java.util.*;
class Solution {
    static int N;
    static Set<Integer> set = new HashSet<>();
    public int solution(int[] nums) {
        N = nums.length;
        
        for(int n : nums){
            set.add(n);
        }
        
        return Math.min(N/2, set.size());
    }
}