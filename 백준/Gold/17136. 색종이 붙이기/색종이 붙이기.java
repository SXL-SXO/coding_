import java.io.*;
import java.util.*;

public class Main {
    static int N = 10, answer = 0;
    static int paper[] = {5,5,5,5,5};
    static boolean map[][] = new boolean[10][10];
    static boolean ischange = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0;i<10;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++){
                map[i][j] = st.nextToken().equals("1");
                if(map[i][j]) ischange = true;
            }
        }
        if(ischange) {
            answer = 26;
            check(0,0);
            answer = answer==26 ? -1 : answer;
        }

        System.out.println(answer);
    }
    static void check(int i, int j){
        //System.out.println(i+" "+j);
        if(i>=N){
            int count = 25;
            for(int p : paper)
                count-=p;
            answer = Math.min(answer, count);
            return;
        } 
        if(j>=N){
            i++;
            j=0;
            check(i, j);
            return;
        }


        if(!map[i][j]){
            check(i,j+1);
            return;
        }
        
        int s;
        boolean imp = false;

        // 현재 내 위치기준으로 쓸 수 있는 종이
        for(s=0;s<5;s++){
            // 현재 내 위치 기준으로 쓸 수 있는 종이 사이즈별로 확인
            imp = false;
            for(int a=0;a<=s;a++){
                if(i+a>=N || j+s>=N || !map[i+a][j+s]) break;
                if(a==s) imp = true;  
            }
            if(!imp) break;
            
            imp = false;
            for(int b=0;b<=s;b++){
                if(!map[i+s][j+b]) break;  
                if(b==s) imp = true; 
            }
            if(!imp) break;

            //여기까지 왔다는 것은 s+1 사이즈의 종이를 붙일 수 있다는 것

            //채우기
            for(int a=0;a<=s;a++){
                map[i+a][j+s] = false;
            }
            for(int b=0;b<=s;b++){
                map[i+s][j+b] = false;
            }

            //다음수 확인
            if(paper[s]>=1) {
                //여기까지 왔다는 것은 s+1 사이즈의 종이를 붙인다는 것
                ischange = true;
                paper[s]--;
                check(i,j+s);
                paper[s]++;
            }
        }

        //복구
        s--;
        for(;s>=0;s--){
            for(int a=0;a<=s;a++){
                map[i+a][j+s] = true;
            }
            for(int b=0;b<=s;b++){
                map[i+s][j+b] = true;
            }
        }
    }
}
