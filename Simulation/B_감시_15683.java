import java.io.*;
import java.util.*;

public class B_감시_15683 {
    static int N, M, answer, count_zero;
    static int[][] map;
    static int[][] dp;
    static List<List<Integer>> cctv = new ArrayList<>();
    static Deque<Integer> dqueue = new ArrayDeque<>();

    static int dy[] = new int[]{-1,1,0,0};
    static int dx[] = new int[]{0,0,-1,1};
    static int go[][] = {{1,2,4,8},{3,12,0,0},{5,6,9,10},{7,11,13,14}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<=5;i++){
            cctv.add(new ArrayList<Integer>());
        }
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) count_zero++;
                else if(map[i][j]!=6) cctv.get(map[i][j]).add(i*M+j);
            }
        }
        int temp;
        for(int i=0;i<cctv.get(5).size();i++){
            temp = cctv.get(5).get(i);
            count_zero-=change(map, temp/M, temp%M, 0);
            count_zero-=change(map, temp/M, temp%M, 1);
            count_zero-=change(map, temp/M, temp%M, 2);
            count_zero-=change(map, temp/M, temp%M, 3);
        }

        for(int i=4;i>0;i--){
            if(cctv.get(i).size()==0) continue;
            else turn(i,cctv.get(i).size()-1);
            break;
        }
        System.out.println(count_zero-answer);
    }
    static void turn(int cctvNum, int Idx){
        //기저조건
        if(cctvNum==0) {
            int temp, mask, y, x, count_see=0;
            int map_[][]=new int[N][];
            for(int i=0;i<N;i++){
                map_[i] = Arrays.copyOf(map[i], M);
            }
            for(int i=0;i<dqueue.size();i++) {
                temp = dqueue.poll();
                mask = temp%100;
                y=temp/100/M;
                x=temp/100%M;
                if(mask==0) continue;       
                for(int j=0;j<4;j++){
                    if(mask==(mask|1<<j)) count_see+=change(map_,y,x,j);
                }     
                dqueue.offer(temp);
            }
            
            // for(int i=0;i<N;i++){
            //     System.out.println(Arrays.toString(map_[i]));
            // }
            // System.out.println("");
            answer = Math.max(answer, count_see);
            return;
        }
        for(int i=0;i<4;i++){
            if(go[cctvNum-1][i]==0) continue;
            dqueue.push(cctv.get(cctvNum).get(Idx)*100+go[cctvNum-1][i]);

            if(Idx==0){
                int j=cctvNum-1;
                for(;j>0;j--){
                    if(cctv.get(j).size()==0) continue;
                    turn(j,cctv.get(j).size()-1);
                    break;
                }
                if(j==0) turn(0, 0);
            }
            else turn(cctvNum, Idx-1);

            dqueue.pop();
        }
    }
    static int change(int map_[][],int y, int x, int type){ 
        int i = y + dy[type], j = x + dx[type];
        if(i<N && i>=0 && j<M && j>=0 ){
            if(map_[i][j] == 6) return 0;
            else if(map_[i][j] == 0){
                map_[i][j] = -1;
                return 1+change(map_, i, j, type);
            }else{
                return change(map_, i, j, type);
            }
        }
        return 0;
    }
}
