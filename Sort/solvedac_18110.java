import java.io.*;
import java.util.*;

public class solvedac_18110 {
    public static void main(String[] args) throws Exception {
        int answer=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int input[] = new int[n];
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        int score[] = Arrays.copyOfRange(input, (int)Math.round(n*0.15), (int)(n-Math.round(n*0.15)));
        //System.out.println(Arrays.toString(score));
        for(int i=0;i<score.length;i++){
            answer+=score[i];
        }
        System.out.println(Math.round((double)answer/score.length));
    }
}
