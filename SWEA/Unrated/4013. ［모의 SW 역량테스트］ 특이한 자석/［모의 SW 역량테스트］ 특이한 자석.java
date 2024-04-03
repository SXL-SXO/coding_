import java.io.*;
import java.util.StringTokenizer;

/**
 * S_특이한자석_4013
 */
public class Solution {
    static int T, K, answer;
    static int[][] magnet;
    static Point[] points;
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            K = Integer.parseInt(br.readLine());
            answer = 0;
            magnet = new int[4][8];
            points = new Point[4];
            for(int i=0;i<4;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<8;j++){
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
                points[i] = new Point();
            }

            for(int k=0;k<K;k++){
                st = new StringTokenizer(br.readLine());
                int now = Integer.parseInt(st.nextToken())-1;
                int how = Integer.parseInt(st.nextToken());
                if(now-1>=0 && (magnet[now][points[now].left] != magnet[now-1][points[now-1].right])) move(now-1, -how, -1);
                if(now+1<4 && (magnet[now][points[now].right] != magnet[now+1][points[now+1].left])) move(now+1, -how, 1);
                points[now].start += -how;
                check(now);
            }
            for(int i=0;i<4;i++){
                answer += magnet[i][points[i].start]*Math.pow(2, i);
            }
            sb.append("#").append(t).append(" ").append(answer).append("\n");        
        }
        System.out.println(sb.toString());
    }
    static void move(int now, int how, int dir){
        // System.out.println(now+dir+" "+points[now+dir]);
        // System.out.println(now+" "+points[now]);
        // System.out.println( (now+dir)+" "+ dir+" "+magnet[now+dir][points[now+dir].left]+" "+magnet[now][points[now].right] );
        //자석 한방향 움직이기
        if(dir == -1 && now+dir>= 0 && (magnet[now][points[now].left] != magnet[now+dir][points[now+dir].right]))
            move(now+dir, -how, dir);

        if(dir == 1 && now+dir< 4 && (magnet[now+dir][points[now+dir].left] != magnet[now][points[now].right]))
            move(now+dir, -how, dir);

        points[now].start += -how;
        check(now);
    }
    static void check(int idx){
        if(points[idx].start < 0) points[idx].start += 8;
        else if(points[idx].start >= 8) points[idx].start -= 8;

        points[idx].left = points[idx].start-2;
        if(points[idx].left < 0) points[idx].left += 8;
        else if(points[idx].left >= 8) points[idx].left -= 8;

        points[idx].right = points[idx].start+2;
        if(points[idx].right < 0) points[idx].right += 8;
        else if(points[idx].right >= 8) points[idx].right -= 8;
        
    }
    static class Point{
        int left, right, start;
        Point(){
            this.start = 0;
            this.right = 2;
            this.left = 6;
        }
        @Override
        public String toString() {
            return "Point [left=" + left + ", right=" + right + ", start=" + start + "]";
        }
    }
}