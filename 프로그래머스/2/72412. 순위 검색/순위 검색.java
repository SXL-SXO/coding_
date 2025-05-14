// 7:08
import java.util.*;

class Solution {
    static int N, M;
    static int answer[];
    static String s[];
    static List<Integer> list;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static Map<String, Integer> type = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        N = info.length;
        M = query.length;
        
        answer = new int[M];
        
        type.put("-", 0);
        type.put("cpp", 1000);
        type.put("java", 2000);
        type.put("python", 3000);
        type.put("backend", 100);
        type.put("frontend", 200);
        type.put("junior", 10);
        type.put("senior", 20);
        type.put("chicken", 1);
        type.put("pizza", 2);
        
        for(int i=0;i<N;i++){
            s = info[i].split(" ");
            
            make(0, Integer.parseInt(s[4])*10000);
        }
              
        int temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            
            if(!map.containsKey(temp%10000)) map.put(temp%10000, new ArrayList<>());
            map.get(temp%10000).add(temp/10000);
        }
        
        int standard, test, start, end, mid;      
        for(int i=0;i<M;i++){
            s = query[i].split(" ");
            standard = 0;
            
            for(int j=0;j<7;j+=2) standard += type.get(s[j]);
            
            test = Integer.parseInt(s[7]);
            
            if(!map.containsKey(standard)) continue;
            
            list = map.getOrDefault(standard, new ArrayList<>());
            
            start = -1;
            end = list.size();
            mid = (start+end)/2;
            
            while(start+1<end){
                mid = (start+end)/2;
                if(!(test <= list.get(mid))) start = mid;
                else end = mid;
            }           
            
            answer[i] = list.size()-end;
        }
        
        return answer;
    }
    static void make(int idx, int num){
        if(idx == 4){
            pq.offer(num);
            return;
        }
        
        make(idx+1, num + type.get(s[idx]));
        make(idx+1, num);
    }
}