import java.util.*;
import java.io.*;


public class Main
{
    static int R, C;
    static char input[][];
    static Node start, answer;
    static boolean visit[];
    
    // 방향 설정
    static int move[][] = {{1, -1, -1, 3}, {-1, -1, 0, 2}, {-1, 1, 3, -1}, {2, 0, -1, -1}};
    
    static int dy[] = {-1,0,1,0};
    static int dx[] = {0,1,0,-1};
    
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    R = Integer.parseInt(st.nextToken());
	    C = Integer.parseInt(st.nextToken());
	    input = new char[R][C];
	    
	    for(int i=0;i<R;i++){
	        input[i] = br.readLine().toCharArray();
	        for(int j=0;j<C;j++){
	            if(input[i][j] == 'M') start = new Node(i,j);
	        }
	    }
	    
	    move();
	    
		System.out.println(sb);
	}
	static void find(){
	    int ny, nx, p = 0;
	    
	    for(int i=0;i<4;i++){
	        ny = answer.y+dy[i];
	        nx = answer.x+dx[i];
	        
            if(ny<0 || ny>=R || nx<0 || nx>=C) continue;
            else if( (input[ny][nx] == '-' && i%2==1) || (input[ny][nx] == '|' && i%2==0) || input[ny][nx] == '+') {
                p = p | (1<<i);
            }else if( input[ny][nx] >= '1' && input[ny][nx] <= '4' && move[i][input[ny][nx]-'1']!= -1){
                p = p | (1<<i);
            }
        }
        
        sb.append(answer.y+1).append(" ").append(answer.x+1).append(" ");
        
        if(p == 3) sb.append('2');
        else if(p == 5) sb.append('|');
        else if(p == 6) sb.append('1');
        else if(p == 9) sb.append('3');
        else if(p == 10) sb.append('-');
        else if(p == 12) sb.append('4');
        else sb.append('+');
	}
	static void move(){
	    Node now = start;
	    
	    int ny, nx, dir = -1;
	    // 첨에는 어느 방향으로 가야하는지 모르니까 찾기
	    for(int i=0;i<4;i++){
	        ny = now.y+dy[i];
	        nx = now.x+dx[i];
	        
            if(ny<0 || ny>=R || nx<0 || nx>=C) continue;
            else if( (input[ny][nx] == '-' && i%2==1) || (input[ny][nx] == '|' && i%2==0) || input[ny][nx] == '+') {
                dir = i;
                now = new Node(ny, nx);
                break;
            }else if( input[ny][nx] >= '1' && input[ny][nx] <= '4' && move[i][input[ny][nx]-'1']!= -1){
                dir = move[i][input[ny][nx]-'1'];
                now = new Node(ny, nx);
                break;
            }
        }
        
	    while(true){
    	    ny = now.y+dy[dir];
	        nx = now.x+dx[dir];
	    
	        if( (input[ny][nx] == '-' && dir%2==1) || (input[ny][nx] == '|' && dir%2==0) || input[ny][nx] == '+') {
                now = new Node(ny, nx);
            }else if( input[ny][nx] >= '1' && input[ny][nx] <= '4' && move[dir][input[ny][nx]-'1']!= -1){
                dir = move[dir][input[ny][nx]-'1'];
                now = new Node(ny, nx);
            }else{
                answer = new Node(ny, nx);
                find();
                return;
            }
	    }
	}
	static class Node{
	    int y, x;
	    Node(int y, int x){
	        this.y=y;
	        this.x=x;
	    }
	}
}
