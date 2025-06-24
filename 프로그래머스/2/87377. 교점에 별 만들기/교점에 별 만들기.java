// 08:18
import java.util.*;

class Solution {
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.y==o2.y ? o1.x-o2.x : o2.y-o1.y);
    static int N, max_y=0, max_x=0, min_y=0, min_x=0;
    static String answer[];
    static StringBuilder sb = new StringBuilder();
    public String[] solution(int[][] line) {
        N = line.length;
        
        long a, b, c, d, e, f;
        int y = 0, x = 0;
        for(int i=0;i<N;i++){      
            a = line[i][0];
            b = line[i][1];
            e = line[i][2];
            for(int j=i+1;j<N;j++){
                c = line[j][0];
                d = line[j][1];
                f = line[j][2];
                
                if(( a*d - b*c )==0) continue;
                
                x = (int)(( b*f - e*d ) / ( a*d - b*c ));
                y = (int)(( e*c - a*f ) / ( a*d - b*c ));
                
                if((( b*f - e*d ) % ( a*d - b*c ) != 0) || (( e*c - a*f ) % ( a*d - b*c ) != 0)) continue;
                
//                 if(line[j][0] == 0 || line[i][0] == 0) {
//                     y = line[i][2]/line[i][1] ;
//                     x = 0;
//                 }
//                 else if(line[j][1] == 0 || line[i][1] == 0) {
//                     x = line[i][2]/line[i][0] ;
//                     y = 0;
//                 }
//                 else{
//                     y = (line[j][2] - line[i][2]) / (line[i][1] - (line[j][1] * line[i][0] / line[j][0]) );
//                     x = -line[i][0]/(line[i][1]*y+line[i][2]);
//                 }
                
//                 if(line[i][0]*x + line[i][1]*y + line[i][2] != 0 || line[j][0]*x + line[j][1]*y + line[j][2] != 0) continue;
                if(pq.isEmpty()){
                    max_y = min_y = y;
                    max_x = min_x = x;
                }else{
                    max_y = Math.max(max_y, y);
                    max_x = Math.max(max_x, x);
                    min_y = Math.min(min_y, y);
                    min_x = Math.min(min_x, x);
                }
                pq.offer(new Node(y, x));
            }
        }
        
        answer = new String [max_y-min_y+1];
        
        Node n = pq.poll();
        for(int i=max_y;i>=min_y;i--){
            sb.setLength(0);
            for(int j=min_x;j<=max_x;j++){
                if(n.y==i && n.x==j) {
                    // System.out.println(i+" "+j);
                    sb.append("*");
                    while(!pq.isEmpty() && n.equals(pq.peek())) n = pq.poll();
                    if(!pq.isEmpty()) n = pq.poll();
                }else sb.append(".");
            }
            answer[max_y-i] = sb.toString();
        }
        
        return answer;
    }
    static class Node{
        int y, x;
        Node(int y, int x){
            this.y=y;
            this.x=x;
        }
        
    
        public boolean equals(Node n){
            return this.y == n.y && this.x == n.x;
        }
    }
}