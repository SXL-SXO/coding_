class Solution {
    public int solution(int[][] board) {
        int answer = board.length*board.length;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]==1)
                   board = check(board,i,j);
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!=0)
                   answer--;
            }
        }
        return answer;
    }
    public int[][] check(int[][] board,int a,int b) {
        int[][] aabb = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<9;i++){
            if(a+aabb[i][0]<0||a+aabb[i][0]>board.length-1||b+aabb[i][1]<0||b+aabb[i][1]>board.length-1)
                continue;
            if(board[a+aabb[i][0]][b+aabb[i][1]]==0){
                board[a+aabb[i][0]][b+aabb[i][1]]=2;
            }
        }
        return board;
    }
}