package BinarySearch;
import java.io.*;
import java.util.StringTokenizer;

public class B_색종이만들기_2630 {
    static int N, answer_w=0, answer_b=0;
    static int paper[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = div(N, 0,0);
        if(answer == 1) answer_b++;
        else if(answer == 0) answer_w++;
        System.out.println(answer_w);
        System.out.println(answer_b);
    }
    static int div(int turn, int y, int x){
        // 1 3  ㅁㅁ
        // 2 4  ㅁㅁ
        // 에서 1 시작위치
        int count_b=0, count_w=0;
        turn/=2;
        int a,b,c,d;
        if(turn == 1){
            a=paper[y+1][x+1];
            b=paper[y+1][x];
            c=paper[y][x+1];
            d=paper[y][x];
        }else{
            a = div(turn, y, x);
            b = div(turn, y+turn, x);
            c = div(turn, y, x+turn);
            d = div(turn, y+turn, x+turn);
        }
        if(a==1) count_b++;
        else if(a==0) count_w++;
        if(b==1) count_b++;
        else if(b==0) count_w++;
        if(c==1) count_b++;
        else if(c==0) count_w++;
        if(d==1) count_b++;
        else if(d==0) count_w++;

        if( count_b==4) return 1;
        else if( count_w==4) return 0;
        answer_b+=count_b;
        answer_w+=count_w;
        return 2;
    }
    static class Node{
        int y,x;
        Node(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
}
