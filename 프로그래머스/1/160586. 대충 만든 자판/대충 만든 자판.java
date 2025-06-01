// 11:46
class Solution {
    static int N, M;
    static int answer[];
    static String input[], output[];
    static int alpa[] = new int[26];
    public int[] solution(String[] keymap, String[] targets) {
        input = keymap;
        output = targets;
        
        N = input.length;
        M = output.length;
        
        
        char c[];
        for(int i=0;i<N;i++){
            c = input[i].toCharArray();
            for(int j=0;j<c.length;j++) if(alpa[c[j]-'A'] == 0 || alpa[c[j]-'A']>j+1) alpa[c[j]-'A'] = j+1;
        }
        
        answer = new int[M];
        for(int i=0;i<M;i++){
            c = output[i].toCharArray();
            for(int j=0;j<c.length;j++) {
                if(alpa[c[j]-'A']!=0) answer[i] += alpa[c[j]-'A'];
                else {
                    answer[i] = -1;
                    break;
                }
           }
        }
        
        return answer;
    }
}