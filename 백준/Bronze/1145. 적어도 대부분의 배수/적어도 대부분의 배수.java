import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[] num = new int[5];
        int n = Integer.MAX_VALUE;
        //서로 다른 5개의 자연수 저장 및 최소값 구하기
        for(int i=0;i<5;i++){
            num[i] = Integer.parseInt(st.nextToken());
            n = Math.min(num[i], n);	//최소값 구하기
        }
        //최소값부터 대부분의 수 조건 만족하는지 탐색
        while(true){
            int count = 0;	//나누어떨어지는 개수 변수
            for(int i=0;i<5;i++){
                if(n % num[i] == 0)	//나누어 떨어질 때
                    count++;
                if(count == 3)
                    break;
            }
            if(count == 3)	//3개 이상 나누어 떨어지면 탐색 종료
                break;
            n++;
        }
        bw.write(n + "");	//대부분의 수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}