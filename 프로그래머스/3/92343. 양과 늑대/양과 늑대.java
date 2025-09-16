// 07:32
import java.util.*;
class Solution {
    static int N, answer = 1;
    static Node tree[];
    public int solution(int[] info, int[][] edges) {
        N = info.length;
        
        tree = new Node[N];
        for(int i=0;i<N;i++) tree[i] = new Node(i, info[i]);
        
        for(int e[] : edges){
            tree[e[1]].parent = e[0];
            if(tree[e[0]].chr1==-1) tree[e[0]].chr1 = e[1];
            else tree[e[0]].chr2 = e[1];
        }
        
        if(tree[0].chr1!=-1) make(tree[0].chr1, 1, 1, 0);
        if(tree[0].chr2!=-1) make(tree[0].chr2, 1, 1, 0);
        
        
        return answer;
    }
    static void make(int idx, int visit, int l, int w){
        visit |= 1<<idx;
        
        if(tree[idx].isL) l++;
        else w++;
        
        if(l<=w) return; 
        answer = Math.max(answer, l);
        if(visit == (1<<N)-1) return;
        
        for(int i=1;i<N;i++) 
            if(((visit & (1<<i)) == 0) && ((visit & (1<<tree[i].parent)) != 0))
                make(i, visit|(1<<i), l, w);
        
    }
    static class Node{
        int idx, parent, chr1, chr2;
        boolean isL;
        Node(int idx, int i) {
            this.idx = idx;
            isL = i == 0;
            chr1 = -1;
            chr2 = -1;
        }
    }
}