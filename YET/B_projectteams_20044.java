import java.io.*;
import java.util.*;

public class B_projectteams_20044 {
    static int N, answer = 100_001;
    static int student[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        student = new int[2*N];
        for(int i=0;i<2*N;i++){
            student[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(student);
        for(int i=0;i<N;i++){
            answer = Math.min(student[i]+student[2*N-1-i], answer);
        }
        System.out.println(answer);
    }
}
