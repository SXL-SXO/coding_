// 05:55
import java.util.*;
class Solution {
    static int N;
    static boolean visit[];
    static int count[];
    static List<List<Integer>> list = new ArrayList<>();
    static Queue<Integer> queue = new ArrayDeque<>();
    public int solution(int n, int[][] edge) {
        N = n;
        
        visit = new boolean[N+1];
        count = new int[N+1];
        
        
        for(int i=0;i<=N;i++) list.add(new ArrayList<>());
        for(int e[] : edge) {
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        
        dijkstra();
        
        System.out.print(Arrays.toString(count));
        
        return find();
    }
    static int find(){
        int max = count[1], total = 1;
        for(int i=1;i<=N;i++){
            if(max < count[i]){
                max = count[i];
                total = 1;
            }else if(max == count[i]) total++;
        }
        return total;
    }
    static void dijkstra(){
        count[1] = 1;
        visit[1] = true;
        queue.offer(1);
        
        int temp;
        while(!queue.isEmpty()){
            temp = queue.poll();           
            
            for(int n : list.get(temp)){
                if(visit[n]) continue;
                visit[n] = true;
                count[n] = count[temp]+1;
                queue.offer(n);
            }
        }
    }
}