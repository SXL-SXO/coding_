import java.util.*;
import java.io.*;

public class Main
{
    static int N, answer = 20;
    static int input[];
    static int del[] = {9, 3, 1};
    static int term[][] = {{2, 1, 0}, {2, 0, 1}, {1, 2, 0}, {1, 0, 2}, {0, 2, 1}, {0, 1, 2}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[3];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        check(1, 0, 0);

        System.out.print(answer);
    }
    static void check(int count, int before, int res) {
        int val, j;
        
        if(count>=answer){
            return;
        }
        
        total : for(int i = before; i<6; i++) {
            val = 0;
            j = 0;
            for(; j<3; j++){
                if(j<N-res-1 && input[term[i][j]]<=0) {
                    return_input(i, j-1);
                    i++;
                    continue total;
                }
                input[term[i][j]]-=del[j];
                if(input[term[i][j]]<=0) val++;
            }
            if(val==3) answer = Math.min(answer, count);
            
            check(count+1, i, val);
            return_input(i, j-1);
         }
    }
    static void return_input(int i, int j){
        for(; j>=0; j--){
            input[term[i][j]]+=del[j];
        }
    }
}