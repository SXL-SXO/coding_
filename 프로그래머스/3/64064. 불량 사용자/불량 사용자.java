// 01:35~01:48
class Solution {
    static int N, M;
    static String input_u[], input_b[];
    static boolean res[] = new boolean[(int)Math.pow(2, 9)];
    public int solution(String[] user_id, String[] banned_id) {
        N = user_id.length;
        M = banned_id.length;
        input_u = user_id;
        input_b = banned_id;
        
        make(0, 0);
        
        int answer = 0;        
        for(int i=0;i<Math.pow(2, 9);i++) if(res[i]) answer++;
            
        return answer;
    }
    static void make(int idx, int visit){
        if(idx==M){
            res[visit] = true;
            return;
        }
        
        char w_b[] = input_b[idx].toCharArray();
        for(int i=0;i<N;i++){
            if((visit & (1<<i)) == 0 && check(input_u[i].toCharArray(), w_b)) make(idx+1, visit|(1<<i));
        }
        
    }
    static boolean check(char w_u[], char w_b[]){
        if(w_u.length != w_b.length) return false;
        int len = w_u.length;
        for(int i=0;i<len;i++){
            if(w_b[i]=='*') continue;
            else if(w_b[i]!=w_u[i]) return false;
        }
        return true;
    }
}