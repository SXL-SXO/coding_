import java.io.*;

public class B_계단오르기_2579 {
    static int N, answer;
    static int stair[][];
    static int input[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stair = new int[N][3];
        input = new int[N];

        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        // stair[0] : 처음 한칸
        // stair[1] : 두번째 한칸
        // stair[2] : 무조건 두칸
        stair[0][0] = input[0];
        stair[0][1] = input[0];
        stair[0][2] = 0;
        for(int i=1;i<N-1;i++){
            stair[i][0] = stair[i-1][2]+input[i];
            stair[i][1] = stair[i-1][0]+input[i];
            stair[i][2] = Math.max(stair[i-1][0], stair[i-1][1]);
        }
        answer = Math.max(stair[N-2][0]+input[N-1], stair[N-2][2]+input[N-1]);
        System.out.println(answer);
    }
}
