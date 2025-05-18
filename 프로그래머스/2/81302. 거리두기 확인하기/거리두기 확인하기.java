// 01:41
import java.util.*;
class Solution {
    static int N;
    static char input[][];
    static boolean visit[][];
    static Queue<Node> queue = new ArrayDeque<>();
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    static int answer[];
    public int[] solution(String[][] places) {
        N = places.length;
        
        answer = new int[N];
        input = new char[5][];
        visit = new boolean[5][5];
        
        for(int i=0;i<N;i++){            
            for(int j=0;j<5;j++){
                input[j] = places[i][j].toCharArray();
                // System.out.println(Arrays.toString(input[j]));
            }                
            
            answer[i] = bfs() ? 1 : 0;  
        }
        return answer;
    }
    static boolean bfs(){
        int ny, nx, size = 2, count = 0;
        Node temp;
        
        queue.clear();
        for(int i=0;i<5;i++){
            Arrays.fill (visit[i], false);
            for(int j=0;j<5;j++){
                if(input[i][j] == 'P') queue.offer(new Node(i, j, -1));
            }
        }  
        
        while(!queue.isEmpty() && count<2){
            size = queue.size();
            for(int j=0; j<size; j++){
                temp = queue.poll();
                for(int i=0;i<4;i++){
                    if(temp.dir != i && temp.dir%2 == i%2) continue;
                    ny = temp.y + dy[i];
                    nx = temp.x + dx[i];

                    if(ny<0 || ny>= 5 || nx<0 || nx>=5 || input[ny][nx] == 'X' ||visit[ny][nx]) continue;
                    else if(input[ny][nx] == 'P') {
                        // System.out.println(temp.y +" "+temp.x+" "+ny+" "+nx+" "+count);
                        return false;
                    }

                    queue.offer(new Node(ny,nx,i));
                }
            }
            count++;
        }
        
        return true;
    }
    static class Node{
        int y, x, dir;
        Node(int y, int x, int dir){
            this.y=y;
            this.x=x;
            this.dir=dir;
        }
    }
}