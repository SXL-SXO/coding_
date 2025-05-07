// 09:35
import java.util.*;
class Solution {
    static int N, answer;
    static int parent[];
    public int solution(int n, int[][] wires) {
        N = n;
        answer = N;
        
        parent = new int[N+1];
        
        for(int i=0;i<N-1;i++){
            for(int j=1;j<=N;j++){
                parent[j] = j;
            }
            for(int j=0;j<N-1;j++){
                if(i==j) continue;
                union(wires[j][0], wires[j][1]);
            }
            for(int j=1;j<=N;j++){
                parent[j] = find(j);
            }
            // System.out.println(Arrays.toString(parent)+" ");
            answer = Math.min(answer, count());
        }     
                
        return answer;
    }
    static int count(){
        int a = 1, b = 0;
        boolean check = true;
        
        for(int i=2;i<=N;i++){
            if(parent[i-1] != parent[i]) check = !check;
            if(check) a++;
            else b++;
        }
        
        return Math.abs(a-b);
    }
    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int x, int y) {
        int nx = find(x);
        int ny = find(y);
        if (nx != ny) {
            parent[nx] = ny;
        }
    }
}