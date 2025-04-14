// 11:37~
import java.util.*;

class Solution {
    static int N, M, max;
    static String rel[][];
    // count = 각 조합 비스마스킹 별 나오는 경우의 수
    static int count[];
    // map Key = 선택된 값들 + " " + 조합비트마스킹 
    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, Integer> answer_map = new HashMap<>();
    public int solution(String[][] relation) {
        int answer = 0;
        N = relation.length;
        M = relation[0].length;        
        rel = relation;
        max = (int)Math.pow(2, M+1);
        count = new int[max];
            
        //i번째의 튜플에 대해 j를 선택한 경우의 경우의 수
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                make(i, j, 1<<j, new StringBuilder(rel[i][j]+" "+(1<<j)));
            }
        }
        // System.out.println(Arrays.toString(count));
        total : for(int i=0;i<max;i++) {
            if(count[i]!=N) continue;
            for(int j : answer_map.keySet()) {
                if((i|j) == i) continue total;
            }
            answer_map.put(i, 0);
            answer++;
        }return answer;
    }
    static void make(int row, int col, int bit, StringBuilder sb){
        if(!map.containsKey(sb.toString())) {            
            map.put(sb.toString(), 0);
            count[bit]++;
        }
        
        StringBuilder temp;
        for(int j=col+1;j<M;j++){
            temp = new StringBuilder(sb);
            temp.append(" ").append(rel[row][j]).append(" ").append(bit|(1<<j));
            make(row, j, bit|(1<<j), temp);
        }
    }
}