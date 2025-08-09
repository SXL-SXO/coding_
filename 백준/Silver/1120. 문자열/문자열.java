import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N, M, answer;
    static char A[], B[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = st.nextToken().toCharArray();
        B = st.nextToken().toCharArray();

        answer = N = A.length;
        M = B.length;

        for(int i=0;i<=M-N;i++) answer = Math.min(answer, check(i));

        System.out.println(answer);
    }
    static int check(int idx) {
        int count = 0;
        for(int i=0;i<N;i++){
            if(A[i] != B[i+idx]) count++;
        }
        return count;
    }
}