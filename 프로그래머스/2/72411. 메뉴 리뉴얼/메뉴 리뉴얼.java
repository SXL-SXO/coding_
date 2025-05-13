// 03:16~

// 2^10 = 1024 ^20 10000000 ^26 64000000
import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static String answer[];
    static int course[] = new int[27];
    static int N;
    static StringBuilder sb = new StringBuilder();
    public String[] solution(String[] orders, int[] cc) {
        // -1 : 아예사용하면 안됨, 0<= : 이 음식개수에서 코스 최대 값
        Arrays.fill(course, -1);
        for(int c : cc) course[c] = 2;
        
        // 2진수로 만들어서 비트마스킹으로 넣기 (java는 String에 좀 더 시간이 많이 걸려서)
        int num;
        char input[];
        for(String s : orders){
            num = 0;
            input = s.toCharArray();
            for(char c : input){
                num += (int)Math.pow(2, c-'A');
            }
            check(num, 0, input.length);
        }
        
        s_sort();
        make_answer();
        
        return answer;
    }
    
    static void make_answer(){
        N = pq.size();
        answer = new String[N];
        for(int i=0;i<N;i++) answer[i] = pq.poll();
    }
    
    // 만들어진 경우의 수 중 각 갯수별로 최대값 구하기
    static void s_sort(){        
        for(String s : map.keySet()){
            if(map.get(s)<2) continue;
            
            if(course[s.length()] == -1 || map.get(s)<course[s.length()]) continue;
            else if(map.get(s)>course[s.length()]) course[s.length()] = map.get(s);
        }
        for(String s : map.keySet()){
            if(map.get(s) == course[s.length()]) pq.offer(s);
        }
    }
    
    // 순열 돌기
    static void check(int num, int idx, int count){
        if(course[count] != -1) {
            sb.setLength(0);
            for(int i=0;i<26;i++){
                if((num & (int)Math.pow(2, i)) != 0) sb.append((char)(i+'A'));
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
        }
        
        if(idx == 26 || count < 2) return;
        
        for(int i = idx; i<26; i++){
            if((num & (int)Math.pow(2, i)) != 0) {
                check(num - (int)Math.pow(2, i), i+1, count-1);
            }
        }
    }
}