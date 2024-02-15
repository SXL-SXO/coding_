import java.io.*;
import java.util.*;

public class 기타레슨_2343 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int lac[] = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            lac[i]= Integer.parseInt(st.nextToken());
            pqueue.offer(new Node(lac[i], i));
        }
        for(int )

    }
    static class Node{
        int time, turn;
        Node(int time, int turn){
            this.time=time;
            this.turn=turn;
        }
    }
}
