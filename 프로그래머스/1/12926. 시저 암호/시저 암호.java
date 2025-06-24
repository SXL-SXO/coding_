// 06:08
class Solution {
    static char input[];
    static int N;
    static StringBuilder sb = new StringBuilder();
    public String solution(String s, int n) {
        input = s.toCharArray();
        N = n;
        
        for(char c : input){
            if(c<='z' && 'a'<=c) sb.append((char)((c+N-'a')%26+'a'));
            else if(c<='Z' && 'A'<=c) sb.append((char)((c+N-'A')%26+'A'));
            else sb.append(' ');
        }
        return sb.toString();
    }
}