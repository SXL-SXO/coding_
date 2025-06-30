// 04:33
class Solution {
    static int N, M;
    static char input[][];
    public int[] solution(String[] wallpaper) {
        int[] answer = {51, 51, -1, -1};
        
        N = wallpaper.length;
        M = wallpaper[0].length();
        
        input = new char[N][];
        
        for(int i=0;i<N;i++){
            input[i] = wallpaper[i].toCharArray();
        }
        
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j] != '#') continue;
                answer[0] = Math.min(answer[0], i);
                answer[1] = Math.min(answer[1], j);
                answer[2] = Math.max(answer[2], i+1);
                answer[3] = Math.max(answer[3], j+1);
            }
        }
        
        return answer;
    }
}