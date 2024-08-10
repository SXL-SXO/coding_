import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        ArrayList<int[]> apple = new ArrayList<int[]>();
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            apple.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())} );
        }
        int L = Integer.parseInt(br.readLine());
        String change[][] = new String[L][2]; 
        for(int i=0;i<L;i++){
            st = new StringTokenizer(br.readLine());
            change[i][0]=st.nextToken();
            change[i][1]=st.nextToken();
        }
        // 입력받기
        int time = 0;
        int now[] = {1, 1}; //내가 현재 있는 위치
        int turn[] = {0, 1}; //내가 가야하는 방향

        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedList<String>();

        //방향회전할때마다 전진멈추고 time도 안건들이기
        for(int i=0;i<change.length+1;i++){
            while(true){                
                if(i<=change.length-1)
                    if(time-1==Integer.parseInt(change[i][0])) //몸이 돌아야할떄
                        break;
                if(time!=0){                
                    now[0]+=turn[0]; //전진
                    now[1]+=turn[1];
                }
                        
                //System.out.println(now[0]+" "+now[1]+" "+time);
                
                sb.setLength(0);
                sb.append(now[0]).append(" ").append(now[1]);

                if(!queue.contains(sb.toString()) || queue.size()==0){
                    //System.out.println(queue.toString());
                    queue.add(sb.toString());
                }
                else{ //전진하다가 자기 몸에 부딪히는 지
                    System.out.println(time);
                    return;
                }
                
                if( now[0]==0 || now[1]==0 || now[0] == N+1 || now[1] == N+1 ){ //전진하다가 벽에 부딪힌 경우
                    System.out.println(time);
                    return;
                }

                int check[];
                int j = 0, size = apple.size();
                for(; j < apple.size(); j++){ //사과먹었는지 확인
                    check = apple.get(j);
                    if(check[0]==now[0] && check[1]==now[1]){
                        apple.remove(check);
                        break;
                    }
                }
                if(apple.size()==size && time!=00)
                    queue.poll(); //안먹었으면 길이 먼저 잘라놓기?

                time+=1;
                 
            }
            if(change[i][1].equals("D")){ //오른쪽 90
                if(turn[0]==0 && turn[1]==1){
                    turn[0]=1;
                    turn[1]=0;
                }else if(turn[0]==1 && turn[1]==0){
                    turn[0]=0;
                    turn[1]=-1;
                }else if(turn[0]==0 && turn[1]==-1){
                    turn[0]=-1;
                    turn[1]=0;
                }else if(turn[0]==-1 && turn[1]==0){
                    turn[0]=0;
                    turn[1]=1;
                }
            }else if(change[i][1].equals("L")){ //왼쪽 90
                if(turn[0]==0 && turn[1]==1){
                    turn[0]=-1;
                    turn[1]=0;
                }else if(turn[0]==-1 && turn[1]==0){
                    turn[0]=0;
                    turn[1]=-1;
                }else if(turn[0]==0 && turn[1]==-1){
                    turn[0]=1;
                    turn[1]=0;
                }else if(turn[0]==1 && turn[1]==0){
                    turn[0]=0;
                    turn[1]=1;
                }
            }
        }
        System.out.println(time);
    }

}
