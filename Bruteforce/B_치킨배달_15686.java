import java.io.*;
import java.util.*;

public class B_치킨배달_15686 {
    static int N, M, c, h, answer;
    static int map[][];
    static int chicken[], house[];
    static int dis[][];
    static int hold[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chicken = new int[13];
        house = new int[2*N];
        hold = new int[M];
        c = 0; h = 0; //치킨집 갯수, 집 갯수
        answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) house[h++] = i*100+j; 
                else if(map[i][j]==2) chicken[c++] = i*100+j; 
            }
        }
        dis = new int[c][h];
        //System.out.println("check");
        for(int i=0;i<c;i++){
            for(int j=0;j<h;j++){

                dis[i][j] = distance(chicken[i],house[j]); //i번째 닭집, j번째의 집 사이의 거리
                //System.out.print(dis[i][j]+" ");
            }
            //System.out.println("");
        }
        

        com(0,0);
        System.out.println(answer);

    }
    static int distance(int chic, int hou){
        return Math.abs(chic/100-hou/100)+Math.abs(chic%100-hou%100);
    }
    static void com(int targetIdx, int SrcIdx){
        if(targetIdx==M) {
            int min, count = 0;
            for(int i=0;i<h;i++){
                min = Integer.MAX_VALUE;
                for(int j=0;j<M;j++){
                    //hold[j]째의 치킨집과 i번째의 집위치 비교해서
                    //제일 작은 i번째집의 치킨거리 구하기
                    min = Math.min(dis[hold[j]][i], min);
                }
                count+=min;
            }
            answer = Math.min(answer,count);
            return;
        }
        if(c-SrcIdx<M-targetIdx) return;
        for(int i=SrcIdx;i<c;i++){
            hold[targetIdx] = i; 
            com(targetIdx+1, i+1);
        }
    }
    
}
