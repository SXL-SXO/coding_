import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{
    static int N, idx = 0, answer = 0, now = 0;
    static int input[], output[], temp[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1,st2;

        N = Integer.parseInt(br.readLine());

        input = new int[N];
        output = new int[N];
        temp = new int[N];

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st1.nextToken());
            output[i] = Integer.parseInt(st2.nextToken());
        }

        if(Arrays.equals(input, output)) answer = 1;
        merge_sort(0,N-1);

        System.out.println(answer);
    }
    static void merge_sort(int p, int r){
        if(p<r){
            int q = (p+r)/2;
            merge_sort(p,q);
            merge_sort(q+1, r);
            merge(p, q, r);
        }
    }
    static void merge(int p, int q, int r){
        int i = p, j = q+1, t = p;
        while(i<=q && j<=r){
            if(input[i]<=input[j]){
                temp[t++] = input[i++];
            }else{
                temp[t++] = input[j++];
            }
        }
        while(i<=q){
            temp[t++] = input[i++];
        }
        while(j<=r){
            temp[t++] = input[j++];
        }

        for(i = p; i<=r; i++){
            input[i] = temp[i];
            while(answer!=1){
                if(input[now]==output[now]){
                    if(now == N-1){
                        answer = 1;
                        break;
                    }
                    now++;
                }else break;
            }
        }
    }
}