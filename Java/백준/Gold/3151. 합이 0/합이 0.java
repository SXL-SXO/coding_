import java.util.*;
import java.io.*;
class Main
{
    static int N;
    static Long answer = 0L;
    static int num[] = new int[20001];
    static int input[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int number, end = 0;
        input = new int[N];
        Arrays.fill(input, -10001);
        for(int i=0;i<N;i++){
            number = Integer.parseInt(st.nextToken());
            if(num[number+10000]==0) input[end++] = number;
            num[number+10000]++;
        }

        if(num[10000]>=3) {
            answer += num[10000];
            answer *= (num[10000]-1);
            answer *= (num[10000]-2);
            answer /= 6;
        }

        Arrays.sort(input);

        int start = input.length-end, a, b;
        for(int i=start;i<N;i++){
            a = input[i];
            if(a>=0) break;
            for(int j=i+1;j<N;j++){
                b = input[j];
                if(a+b>10000) break;
                if(a+b<-10000 || num[10000-(a+b)]==0 ) continue;
//                System.out.println(a+" "+num[a+10000]+" "+b+" "+num[b+10000]+" "+(a+b)*-1+" "+num[10000-(a+b)]+" "+answer);
                if(a == b) answer += (long)(num[a+10000]-1)*(long)(num[b+10000]-1)*(long)num[10000-(a+b)];
                else if(-a == a+b){
                    if(num[a+10000]>1) answer += ((long)(num[a+10000]-1)*(long)num[b+10000]*(long)num[10000+a])/2;
                }
                else if(-b == a+b){
                    if(num[b+10000]>1) answer += ((long)num[a+10000]*(long)(num[b+10000]-1)*(long)num[10000+b])/2;
                }
                else if(b < -a-b) answer += (long)num[a+10000]*(long)num[b+10000]*(long)num[10000-(a+b)];
            }
        }
        System.out.println(answer);
    }
}
