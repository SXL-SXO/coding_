//01:14
import java.util.*;
class Solution {
    static int N, mmax, max;
    static boolean visit[];
    static int parent[], input[], count[];
    public int solution(int[] cards) {
        N = cards.length;
        
        parent = new int[N];
        input = new int[N];
        count = new int[N];
        visit = new boolean[N];

        for(int i=0;i<N;i++) {
            parent[i] = i;
            input[i] = cards[i]-1;
        }
        for(int i=0;i<N;i++) parent[i] = find(i);
        for(int i=0;i<N;i++) count[parent[i]]++;
        
        for(int i=0;i<N;i++){
            if(mmax<count[i]) {
                max = mmax;
                mmax = count[i];
            }else if(max<count[i]) max = count[i];
        }
        // System.out.println(Arrays.toString(parent));
        
        return mmax*max;
    }
    static int find(int idx){
        if(input[idx]==idx) return idx;
        else if(visit[idx]) return parent[idx];
        
        visit[idx] = true;
        return parent[idx] = find(input[idx]);
    }
}