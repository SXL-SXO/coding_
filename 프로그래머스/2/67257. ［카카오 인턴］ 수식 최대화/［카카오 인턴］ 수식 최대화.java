// 12:50
import java.util.*;
class Solution {
    static int N = 1;
    static long answer = 0;
    static int parent[];
    static long input[];
    static String oper[] = {"+", "-", "*"};
    static Map<String, List<Integer>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public long solution(String expression) {
        String s[] = expression.split("");
        
        map.put("+", new ArrayList<>());
        map.put("-", new ArrayList<>());
        map.put("*", new ArrayList<>());
        
        for(String ss : s) if(map.containsKey(ss)) N++;
        
        parent = new int[N];
        input = new long[N];
        
        // List<Integer> list;
        int idx = 0;
        for(String ss : s){
            if(!map.containsKey(ss)){
                sb.append(ss);
                continue;
            }
            
            input[idx] = Long.parseLong(sb.toString());
            parent[idx] = idx;
            sb.setLength(0);

            // list = map.get(ss).add(idx++);
            // map.put(ss, list);
            
            map.get(ss).add(idx++);
        }
        input[idx] = Long.parseLong(sb.toString());
        parent[idx] = idx;
        
        // 6가지 전부 계산하기
        make(0, input);
        
        return answer;
    }
    static void make(int visit, long num[]){
        if(visit == (1<<3)-1){
            // System.out.println(Arrays.toString(num));
            answer = Math.max(answer, Math.abs(num[0]));
            return;
        }
        
        for(int i=0;i<3;i++){
            if((visit & 1<<i) == 0) {
                make(visit|(1<<i), cal(num, i));
                reverse_cal(i);
            }
        }
    }
    static void reverse_cal(int op){
        for(int i : map.get(oper[op])){
            parent[i+1] = i+1;
        }
        return;
    }
    static long[] cal(long num[], int op){
        long res[] = num.clone();
        
        for(int i : map.get(oper[op])){
            int idx = find(i);
            if(op==0) res[idx] = res[idx]+res[i+1];
            else if(op==1) res[idx] = res[idx]-res[i+1];
            else if(op==2) res[idx] = res[idx]*res[i+1];
            
            parent[i+1] = idx;
        }
        
        return res;
    }
    static int find(int a){
        if(parent[a] == a) return a;
        return find(parent[a]);
    }
}