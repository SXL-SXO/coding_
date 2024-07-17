class Solution {
    static int dy[][]={{0,0,0},{1,1,1},{2,2,2},{0,1,2},{0,1,2},{0,1,2},{0,1,2},{2,1,0}};
    static int dx[][]={{0,1,2},{0,1,2},{0,1,2},{0,0,0},{1,1,1},{2,2,2},{0,1,2},{0,1,2}};
    public int solution(String[] board) {
        int answer = 0, count_o = 0, count_x = 0;
        
        int b_size = board[0].length();
        for(String b : board){
            for(int j=0;j<b_size;j++){
                if(b.charAt(j)=='O') count_o++;
                else if(b.charAt(j)=='X') count_x++;
            }
        }
        if(Math.abs(count_o-count_x)>1) answer = 0;
        else if(count_o>count_x) {
            answer = 1;
            // x가 만들어지면 안됨
            first : for(int i=0;i<8;i++){
                if(board[dy[i][0]].charAt(dx[i][0])!='X') continue;
                for(int j=1;j<3;j++){
                    if('X' != board[dy[i][j]].charAt(dx[i][j])) {
                        continue first;
                    }
                }    
                answer = 0;
            }
        }
        else if(count_o==count_x) {
            answer = 1;
            // o가 만들어지면 안됨
            first : for(int i=0;i<8;i++){
                if(board[dy[i][0]].charAt(dx[i][0])!='O') continue;
                for(int j=1;j<3;j++){
                    if('O' != board[dy[i][j]].charAt(dx[i][j])) {
                        continue first;
                    }
                }    
                answer = 0;
            }
        }
        return answer;
    }
}