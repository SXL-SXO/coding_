import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int N, M, max, maxday, answer;
    static int sc[] = new int [50001];
    static Node days[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        days = new Node[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            days[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int j = days[i].s;j<=days[i].e;j++){
                sc[j]++;
            }
        }

        findbestday();
        startcount();

        System.out.println(answer);
    }
    static void startcount(){
        for(int i = 0; i < M; i++){
            if((days[i].s<=maxday && maxday+7*N<=days[i].e)
                ||(days[i].s>=maxday && maxday+7*N>=days[i].e)
                ||(days[i].s<=maxday && maxday+7*N>=days[i].e)
                ||(days[i].s>=maxday && maxday+7*N<=days[i].e)
            ){
                for(int j=0;j<N;j++){
                    if(days[i].e < maxday+j*7 || maxday+(j+1)*7 <= days[i].s) continue;
                    answer++;
                }
            }
        }
    }
    static void findbestday() {
        int startday, endday, count;
        startday = 1;
        endday = 1+7*N;
        count = 0;
        maxday = 1;
        // 뭔가 슬라이딩 윈도우인데
        for(int i = 1; i < endday; i++){
            count+=sc[i];
        }
        max = count;
        for(int i = 2; endday<50001; i++){
            count = count-sc[startday]+sc[endday];
            if(max < count){
                max = count;
                maxday = i;
            }
            startday++;
            endday++;
        }
    }

    static class Node{
        int s,e;
        Node(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
}