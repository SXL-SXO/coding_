// 12:51

import java.util.*;
class Solution {
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean visit[][];
    static int input[][];
    static int N, M;
    public int solution(int n, int m, String[] board) {
        N = n;
        M = m;
        input = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                input[i][j] = board[i].charAt(j)-'A'+1;
            }
        }
        
        while(true){            
            for(int i=0;i<N-1;i++){
                for(int j=0;j<M-1;j++){
                    if(input[i][j]!=0) check(i, j);
                }
            }
            if(queue.isEmpty()) break;
            else{
                turn();
                for(int j=0;j<M;j++){
                    move(j);
                }
            }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                // System.out.print(input[i][j]);
                System.out.print((char)(input[i][j]-1+'A'));
            }
            System.out.println("");
        }
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(input[i][j]==0) answer++;
            }
        }
        return answer;
    }
    static void turn(){
        int temp, y, x;
        while(!queue.isEmpty()){
            temp = queue.poll();
            y = temp/M;
            x = temp%M;
            // System.out.println(y+" "+x);
            visit[y][x] = false;
            input[y][x] = 0;
        }
    }
    static void move(int j){
        for(int i=N-1;i>0;i--){
            if(input[i][j] != 0) continue;
            for(int k=i-1;k>=0;k--){
                if(input[k][j] != 0){
                    input[i][j] = input[k][j];
                    input[k][j] = 0;
                    break;
                }
            }
        }
    }
    static void check(int i, int j){
        if(input[i][j] == input[i+1][j] && input[i][j] == input[i][j+1] && input[i][j] == input[i+1][j+1]) {
            if(!visit[i][j]) {
                queue.offer(i*M+j);
                visit[i][j] = true;
            }
            if(!visit[i][j+1]) {
                queue.offer(i*M+(j+1));
                visit[i][j+1] = true;
            }
            if(!visit[i+1][j]) {
                queue.offer((i+1)*M+j);
                visit[i+1][j] = true;
            }
            if(!visit[i+1][j+1]) {
                queue.offer((i+1)*M+(j+1));
                visit[i+1][j+1] = true;
            }
        }
    }
}